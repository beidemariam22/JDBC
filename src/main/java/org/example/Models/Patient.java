package org.example.Models;

import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.BuilderPattern.PatientBuilder;

@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {
    @XmlElement(name = "patientId")
    @JsonProperty("patient_id")
    private int patientId;

    @XmlElement(name = "name")
    @JsonProperty("name")
    private String patientName;

    @XmlElement(name = "dateOfBirth")
    @JsonProperty("date_of_birth")
    private String patientDateOfBirth;

    @XmlElement(name = "gender")
    @JsonProperty("gender")
    private String patientGender;

    @XmlElement(name = "address")
    @JsonProperty("address")
    private String patientAddress;

    @XmlElement(name = "phoneNumber")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @XmlElement(name = "email")
    @JsonProperty("email")
    private String patientEmail;

    @XmlElement(name = "nurseId")
    //@JsonProperty("nurse_id")
    private Nurse nurses;

    public Patient(){

    }
    public Patient(int patientId, String patientName, String patientDateOfBirth, String patientGender,
                   String patientAddress, String phoneNumber, String patientEmail, Nurse nurses) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientDateOfBirth = patientDateOfBirth;
        this.patientGender = patientGender;
        this.patientAddress = patientAddress;
        this.phoneNumber = phoneNumber;
        this.patientEmail = patientEmail;
        this.nurses=nurses;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientDateOfBirth() {
        return patientDateOfBirth;
    }

    public void setPatientDateOfBirth(String patientDateOfBirth) {
        this.patientDateOfBirth = patientDateOfBirth;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public Nurse getNurses() {
        return nurses;
    }

    public void setNurses(Nurse nurses) {
        this.nurses = nurses;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientDateOfBirth='" + patientDateOfBirth + '\'' +
                ", patientGender='" + patientGender + '\'' +
                ", patientAddress='" + patientAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", patientEmail='" + patientEmail + '\'' +
                ", nurses=" + nurses +
                '}';
    }
}


