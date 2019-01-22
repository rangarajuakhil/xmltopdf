package com.jms.xmltopdf.controller;

import com.jms.xmltopdf.payload.DownloadFileResponse;
import com.jms.xmltopdf.service.ConvertToPDFService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class XmlToPdfController {
    private static final Logger logger = LoggerFactory.getLogger(XmlToPdfController.class);

    @Autowired
    private ConvertToPDFService convertToPDFService;

    @PostMapping("/convert")
    public DownloadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = convertToPDFService.getPDF(file);
            if(fileName.toLowerCase().contains("invalid")){
                return new DownloadFileResponse(file.getOriginalFilename(), fileName,
                        file.getContentType(),String.valueOf(0).concat(" Kb"));
            }
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(fileName)
                    .toUriString();
            File pdf = new File(fileName);
            InputStream inputStream = new FileInputStream(pdf);
            MultipartFile pdfFile = new MockMultipartFile(fileName,pdf.getName(),"application/pdf", IOUtils.toByteArray(inputStream));
            return new DownloadFileResponse(fileName, fileDownloadUri,
                    pdfFile.getContentType(), String.valueOf(pdfFile.getSize()/1000).concat(" Kb"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @PostMapping("/convertAll")
    public List<DownloadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = convertToPDFService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
