package com.jms.xmltopdf.service;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jms.xmltopdf.eventhandler.CustomValidationEventHandler;
import com.jms.xmltopdf.exception.FileStorageException;
import com.jms.xmltopdf.exception.MyFileNotFoundException;
import com.jms.xmltopdf.filters.NamespaceFilter;
import com.jms.xmltopdf.jaxb.Envelope;
import com.jms.xmltopdf.jaxb.ObjectFactory;
import com.jms.xmltopdf.property.FileStorageProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXSource;

@Service
public class ConvertToPDFService {

    private final Path uploadLocation;
    private final Path downloadLocation;
    private Envelope envelope;

    private Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private Font bluefont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.BLUE);
    private Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    public ConvertToPDFService(FileStorageProperties fileStorageProperties) {
        this.uploadLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        this.downloadLocation = Paths.get(fileStorageProperties.getDownloadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.uploadLocation);
            Files.createDirectories(this.downloadLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }

    }

    public String getPDF(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileNameWithOutExt = FilenameUtils.removeExtension(fileName);
        String pdfFileName = fileNameWithOutExt+"."+"pdf";
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                return "Invalid Path Sequence in the File: " + fileName;
            }

            if(!checkFileExtension(fileName).equalsIgnoreCase("xml")){
                return "Invalid XML file:  " + fileName;
            }

            // Copy file to the upload location (Replacing existing file with the same name)
            Path uploadLocation = this.uploadLocation.resolve(fileName);
            Files.copy(file.getInputStream(), uploadLocation, StandardCopyOption.REPLACE_EXISTING);
            String pdfFile = convertXmlToPDF(file,pdfFileName);

            return pdfFile;
        } catch (IOException ex) {
            throw new FileStorageException("Could not Convert file " + fileName + ". Please try again!", ex);
        }
    }

    private String convertXmlToPDF(MultipartFile file, String pdfFileName){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            NamespaceFilter inFilter = new NamespaceFilter("http://schemas.xmlsoap.org/soap/envelope/", true);
            inFilter.setParent(reader);
            InputSource is = new InputSource(new BufferedInputStream(file.getInputStream()));
            SAXSource source = new SAXSource(inFilter, is);

            jaxbUnmarshaller.setEventHandler(new CustomValidationEventHandler());

            envelope = (Envelope) jaxbUnmarshaller.unmarshal(source);

            Rectangle pageSize = new Rectangle(PageSize.A4.rotate());
            pageSize.setBackgroundColor(new BaseColor(241, 241, 241));

            Document document = new Document(pageSize, 2, 2, 15, 10);
            PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));
            document.open();
            populatePDF(document, envelope);
            document.close();

            File pdf = new File(pdfFileName);
            InputStream inputStream = new FileInputStream(pdf);
            // Copy file to the download location (Replacing existing file with the same name)
            Path downloadLocation = this.downloadLocation.resolve(pdfFileName);
            Files.copy(inputStream, downloadLocation, StandardCopyOption.REPLACE_EXISTING);


        } catch (JAXBException | SAXException | IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return pdfFileName;
    }

    private void populatePDF(Document document, Envelope envelope) {
        try {
            Paragraph preface = new Paragraph();
            preface.setAlignment(Element.ALIGN_CENTER);
            addEmptyLine(preface, 1);
            preface.add(new Paragraph("Inmate Medical Record", catFont));
            addEmptyLine(preface, 1);
            preface.add(new Paragraph(
                    "This document is a preliminary version.",
                    bluefont));

            document.add(preface);
            addEmptyLine(preface, 2);

            PdfPTable basicTab = new PdfPTable(1);
            PdfPCell ticketCell =
                    new PdfPCell(new Phrase("Ticket: " + envelope.getBody().getReturn().getTicketId(),bluefont));
            ticketCell.setBorderWidth(0);
            ticketCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            basicTab.addCell(ticketCell);
            addSection(basicTab, "Basic Details");

            document.add(basicTab);
            addEmptyLine(preface, 2);

            PdfPTable table = new PdfPTable(2);
            float[] columnWidth =
                    new float[]{20f, 80f};
            table.setWidths(columnWidth);
            table.setWidthPercentage(100.0f);
            addRowsWithValues(table, "PATIENT ID", envelope.getBody().getReturn().getPatientId());
            addRowsWithValues(table, "PATIENT NAME", envelope.getBody().getReturn().getPatient());
            addRowsWithValues(table, "DATE OF BIRTH", envelope.getBody().getReturn().getDOB());
            addRowsWithValues(table, "SEX", envelope.getBody().getReturn().getSex());
            addRowsWithValues(table, "AGE", envelope.getBody().getReturn().getAge());
            addRowsWithValues(table, "ENCOUNTER ID", envelope.getBody().getReturn().getEncounterId());
            addRowsWithValues(table, "ENC TYPE", envelope.getBody().getReturn().getEnctype());
            addRowsWithValues(table, "PROVIDER ID", envelope.getBody().getReturn().getProviderId());
            addRowsWithValues(table, "CONTROL NO", envelope.getBody().getReturn().getControlNo());
            document.add(table);

            addEmptyLine(preface, 2);
            PdfPTable visits = new PdfPTable(1);
            addSection(visits, "Visit Details");
            document.add(visits);

            PdfPTable visitTab = new PdfPTable(2);
            float[] columnWidth1 =
                    new float[]{20f, 80f};
            table.setWidths(columnWidth1);
            table.setWidthPercentage(100.0f);
            addRowsWithValues(visitTab, "APPT FACILITY ID", envelope.getBody().getReturn().getApptFacilityId());
            addRowsWithValues(visitTab, "ADDRESS", envelope.getBody().getReturn().getAddress());
            addRowsWithValues(visitTab, "PHONE", envelope.getBody().getReturn().getPhone());
            addRowsWithValues(visitTab, "DATE", envelope.getBody().getReturn().getDate() + " - " + envelope.getBody().getReturn().getTime());
            addRowsWithValues(visitTab, "DOCTOR", envelope.getBody().getReturn().getAge());
            addRowsWithValues(visitTab, "USER", envelope.getBody().getReturn().getEncounterId());
            addRowsWithValues(visitTab, "ASSIGNED TO", envelope.getBody().getReturn().getAssignedTo());
            addRowsWithValues(visitTab, "CALLER", envelope.getBody().getReturn().getCaller());
            addRowsWithValues(visitTab, "REASON", envelope.getBody().getReturn().getReason());
            addLongCell(visitTab, "MESSAGE", envelope.getBody().getReturn().getMessage());
            addLongCell(visitTab, "ACTION TAKEN", envelope.getBody().getReturn().getActiontaken());
            addLongCell(visitTab, "NOTES", envelope.getBody().getReturn().getNotes());

            java.util.List<Envelope.Body.Return.SubItems.Item> items = envelope.getBody().getReturn().getSubItems().getItem();
            addNestedTable(visitTab, "SUB-ITEMS", items);
            document.add(visitTab);

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    private void addNestedTable(PdfPTable table, String key, List<Envelope.Body.Return.SubItems.Item> items) {
        PdfPCell cell1 = new PdfPCell(new Phrase(key, smallBold));
        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell cell2 = new PdfPCell(new Phrase("ITEMS"));

        PdfPTable nestedTable = new PdfPTable(2);
        PdfPCell n1 = new PdfPCell(new Phrase("ITEM NAME",smallBold));
        n1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        n1.setHorizontalAlignment(Element.ALIGN_CENTER);
        nestedTable.addCell(n1);

        PdfPCell n2 = new PdfPCell(new Phrase("ITEM VALUE",smallBold));
        n2.setBackgroundColor(BaseColor.LIGHT_GRAY);
        n2.setHorizontalAlignment(Element.ALIGN_CENTER);
        nestedTable.addCell(n2);

        for(Envelope.Body.Return.SubItems.Item item : items){
            nestedTable.addCell(new PdfPCell(new Phrase(item.getItemName())));
            nestedTable.addCell(new PdfPCell(new Phrase(item.getItemValue())));
        }
        cell2.addElement(nestedTable);
        table.addCell(cell1);
        table.addCell(cell2);
    }


    private void addSection(PdfPTable table, String sectionName) {
        table.setSpacingBefore(10);
        table.setSpacingAfter(10);
        table.setWidthPercentage(100.0f);
        PdfPCell titleCell =
                new PdfPCell(new Phrase(sectionName, subFont));
        titleCell.setBorderWidth(0);
        titleCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        titleCell.setFixedHeight(20f);
        titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(titleCell);
    }

    private void addRowsWithValues(PdfPTable table, String key, String val) {
        PdfPCell cell1 = new PdfPCell(new Phrase(key, smallBold));
        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell cell2 = new PdfPCell(new Phrase(val));

        table.addCell(cell1);
        table.addCell(cell2);
    }

    private void addLongCell(PdfPTable table, String key, String val){
        PdfPCell cell1 = new PdfPCell(new Phrase(key, smallBold));
        cell1.setFixedHeight(50f);
        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        PdfPCell cell2 = new PdfPCell(new Phrase(val));
        cell2.setFixedHeight(50f);
        table.addCell(cell1);
        table.addCell(cell2);
    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    public String checkFileExtension(String fileName)
    {
        return FilenameUtils.getExtension(fileName);
    }


    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.downloadLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
}
