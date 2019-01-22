
package com.jms.xmltopdf.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Body">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="return">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="EncounterId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="PatientId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="ProviderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="ControlNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="patient" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="DOB" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="ApptFacilityId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="doctor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="assignedTo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="enctype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="caller" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="actiontaken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="notes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="ticketId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="subItems">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="itemName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="itemValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="VirtualFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="eMsgs" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "body"
})
@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
public class Envelope {

    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
    protected Envelope.Body body;

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link Envelope.Body }
     *     
     */
    public Envelope.Body getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link Envelope.Body }
     *     
     */
    public void setBody(Envelope.Body value) {
        this.body = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="return">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="EncounterId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="PatientId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="ProviderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="ControlNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="patient" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="DOB" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="ApptFacilityId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="doctor" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="assignedTo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="enctype" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="caller" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="actiontaken" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="notes" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="ticketId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="subItems">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="itemName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="itemValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="VirtualFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="eMsgs" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "_return"
    })
    public static class Body {

        @XmlElement(name = "return", namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
        protected Envelope.Body.Return _return;

        /**
         * Gets the value of the return property.
         * 
         * @return
         *     possible object is
         *     {@link Envelope.Body.Return }
         *     
         */
        public Envelope.Body.Return getReturn() {
            return _return;
        }

        /**
         * Sets the value of the return property.
         * 
         * @param value
         *     allowed object is
         *     {@link Envelope.Body.Return }
         *     
         */
        public void setReturn(Envelope.Body.Return value) {
            this._return = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="EncounterId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="PatientId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="ProviderId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="ControlNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="patient" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="DOB" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="ApptFacilityId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="doctor" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="assignedTo" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="enctype" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="caller" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="actiontaken" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="notes" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="ticketId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="subItems">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="itemName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="itemValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="VirtualFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="eMsgs" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "encounterId",
            "patientId",
            "providerId",
            "controlNo",
            "patient",
            "dob",
            "apptFacilityId",
            "sex",
            "age",
            "phone",
            "address",
            "date",
            "time",
            "doctor",
            "user",
            "assignedTo",
            "enctype",
            "caller",
            "reason",
            "message",
            "actiontaken",
            "notes",
            "ticketId",
            "subItems",
            "virtualFlag",
            "eMsgs"
        })
        public static class Return {

            @XmlElement(name = "EncounterId", namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String encounterId;
            @XmlElement(name = "PatientId", namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String patientId;
            @XmlElement(name = "ProviderId", namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String providerId;
            @XmlElement(name = "ControlNo", namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String controlNo;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String patient;
            @XmlElement(name = "DOB", namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String dob;
            @XmlElement(name = "ApptFacilityId", namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String apptFacilityId;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String sex;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String age;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String phone;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String address;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String date;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String time;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String doctor;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String user;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String assignedTo;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String enctype;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String caller;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String reason;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String message;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String actiontaken;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String notes;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String ticketId;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected Envelope.Body.Return.SubItems subItems;
            @XmlElement(name = "VirtualFlag", namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String virtualFlag;
            @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
            protected String eMsgs;

            /**
             * Gets the value of the encounterId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEncounterId() {
                return encounterId;
            }

            /**
             * Sets the value of the encounterId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEncounterId(String value) {
                this.encounterId = value;
            }

            /**
             * Gets the value of the patientId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPatientId() {
                return patientId;
            }

            /**
             * Sets the value of the patientId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPatientId(String value) {
                this.patientId = value;
            }

            /**
             * Gets the value of the providerId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProviderId() {
                return providerId;
            }

            /**
             * Sets the value of the providerId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProviderId(String value) {
                this.providerId = value;
            }

            /**
             * Gets the value of the controlNo property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getControlNo() {
                return controlNo;
            }

            /**
             * Sets the value of the controlNo property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setControlNo(String value) {
                this.controlNo = value;
            }

            /**
             * Gets the value of the patient property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPatient() {
                return patient;
            }

            /**
             * Sets the value of the patient property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPatient(String value) {
                this.patient = value;
            }

            /**
             * Gets the value of the dob property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDOB() {
                return dob;
            }

            /**
             * Sets the value of the dob property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDOB(String value) {
                this.dob = value;
            }

            /**
             * Gets the value of the apptFacilityId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getApptFacilityId() {
                return apptFacilityId;
            }

            /**
             * Sets the value of the apptFacilityId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setApptFacilityId(String value) {
                this.apptFacilityId = value;
            }

            /**
             * Gets the value of the sex property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSex() {
                return sex;
            }

            /**
             * Sets the value of the sex property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSex(String value) {
                this.sex = value;
            }

            /**
             * Gets the value of the age property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAge() {
                return age;
            }

            /**
             * Sets the value of the age property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAge(String value) {
                this.age = value;
            }

            /**
             * Gets the value of the phone property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPhone() {
                return phone;
            }

            /**
             * Sets the value of the phone property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPhone(String value) {
                this.phone = value;
            }

            /**
             * Gets the value of the address property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddress() {
                return address;
            }

            /**
             * Sets the value of the address property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddress(String value) {
                this.address = value;
            }

            /**
             * Gets the value of the date property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDate() {
                return date;
            }

            /**
             * Sets the value of the date property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDate(String value) {
                this.date = value;
            }

            /**
             * Gets the value of the time property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTime() {
                return time;
            }

            /**
             * Sets the value of the time property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTime(String value) {
                this.time = value;
            }

            /**
             * Gets the value of the doctor property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDoctor() {
                return doctor;
            }

            /**
             * Sets the value of the doctor property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDoctor(String value) {
                this.doctor = value;
            }

            /**
             * Gets the value of the user property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUser() {
                return user;
            }

            /**
             * Sets the value of the user property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUser(String value) {
                this.user = value;
            }

            /**
             * Gets the value of the assignedTo property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAssignedTo() {
                return assignedTo;
            }

            /**
             * Sets the value of the assignedTo property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAssignedTo(String value) {
                this.assignedTo = value;
            }

            /**
             * Gets the value of the enctype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEnctype() {
                return enctype;
            }

            /**
             * Sets the value of the enctype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEnctype(String value) {
                this.enctype = value;
            }

            /**
             * Gets the value of the caller property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCaller() {
                return caller;
            }

            /**
             * Sets the value of the caller property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCaller(String value) {
                this.caller = value;
            }

            /**
             * Gets the value of the reason property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReason() {
                return reason;
            }

            /**
             * Sets the value of the reason property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReason(String value) {
                this.reason = value;
            }

            /**
             * Gets the value of the message property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMessage() {
                return message;
            }

            /**
             * Sets the value of the message property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMessage(String value) {
                this.message = value;
            }

            /**
             * Gets the value of the actiontaken property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getActiontaken() {
                return actiontaken;
            }

            /**
             * Sets the value of the actiontaken property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setActiontaken(String value) {
                this.actiontaken = value;
            }

            /**
             * Gets the value of the notes property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNotes() {
                return notes;
            }

            /**
             * Sets the value of the notes property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNotes(String value) {
                this.notes = value;
            }

            /**
             * Gets the value of the ticketId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTicketId() {
                return ticketId;
            }

            /**
             * Sets the value of the ticketId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTicketId(String value) {
                this.ticketId = value;
            }

            /**
             * Gets the value of the subItems property.
             * 
             * @return
             *     possible object is
             *     {@link Envelope.Body.Return.SubItems }
             *     
             */
            public Envelope.Body.Return.SubItems getSubItems() {
                return subItems;
            }

            /**
             * Sets the value of the subItems property.
             * 
             * @param value
             *     allowed object is
             *     {@link Envelope.Body.Return.SubItems }
             *     
             */
            public void setSubItems(Envelope.Body.Return.SubItems value) {
                this.subItems = value;
            }

            /**
             * Gets the value of the virtualFlag property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVirtualFlag() {
                return virtualFlag;
            }

            /**
             * Sets the value of the virtualFlag property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVirtualFlag(String value) {
                this.virtualFlag = value;
            }

            /**
             * Gets the value of the eMsgs property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEMsgs() {
                return eMsgs;
            }

            /**
             * Sets the value of the eMsgs property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEMsgs(String value) {
                this.eMsgs = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="itemName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="itemValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "item"
            })
            public static class SubItems {

                @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/")
                protected List<Envelope.Body.Return.SubItems.Item> item;

                /**
                 * Gets the value of the item property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the item property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getItem().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Envelope.Body.Return.SubItems.Item }
                 * 
                 * 
                 */
                public List<Envelope.Body.Return.SubItems.Item> getItem() {
                    if (item == null) {
                        item = new ArrayList<Envelope.Body.Return.SubItems.Item>();
                    }
                    return this.item;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="itemName" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="itemValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "itemName",
                    "itemValue"
                })
                public static class Item {

                    @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
                    protected String itemName;
                    @XmlElement(namespace = "http://schemas.xmlsoap.org/soap/envelope/", required = true)
                    protected String itemValue;

                    /**
                     * Gets the value of the itemName property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getItemName() {
                        return itemName;
                    }

                    /**
                     * Sets the value of the itemName property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setItemName(String value) {
                        this.itemName = value;
                    }

                    /**
                     * Gets the value of the itemValue property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getItemValue() {
                        return itemValue;
                    }

                    /**
                     * Sets the value of the itemValue property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setItemValue(String value) {
                        this.itemValue = value;
                    }

                }

            }

        }

    }

}
