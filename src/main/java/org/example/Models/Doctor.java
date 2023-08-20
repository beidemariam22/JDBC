package org.example.Models;

import javax.xml.bind.annotation.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.BuilderPattern.DoctorBuilder;


@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Doctor {
    @XmlElement(name = "doctorId")
    @JsonProperty("doctor_id")
    private int doctorId;

    @XmlElement(name = "name")
    @JsonProperty("name")
    private String doctorName;

    @XmlElement(name = "qualification")
    @JsonProperty("qualification")
    private String doctorQualification;

    @XmlElement(name = "phoneNumber")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @XmlElement(name = "email")
    @JsonProperty("email")
    private String email;

    @XmlElementWrapper(name = "patients")
    @XmlElement(name = "patient")
    @JsonProperty("patients")
    private List<Patient> patientsList;



    public Doctor() {
    }

    public Doctor(int doctorId, String doctorName, String doctorQualification, String phoneNumber, String email) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorQualification = doctorQualification;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorQualification() {
        return doctorQualification;
    }

    public void setDoctorQualification(String doctorQualification) {
        this.doctorQualification = doctorQualification;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Patient> getPatientsList() {
        return patientsList;
    }

    public void setPatientsList(List<Patient> patientsList) {
        this.patientsList = patientsList;
    }
    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", doctorQualification='" + doctorQualification + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", patientsList=" + patientsList +
                '}';
    }
}
