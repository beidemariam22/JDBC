package org.example.Models;

import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.BuilderPattern.NurseBuilder;

@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Nurse {
    @XmlElement(name = "nurseId")
    @JsonProperty("nurse_id")
    private int nurseId;

    @XmlElement(name = "name")
    @JsonProperty("name")
    private String nurseName;

    @XmlElement(name = "department")
    @JsonProperty("department")
    private String department;

    @XmlElement(name = "phoneNumber")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @XmlElement(name = "email")
    @JsonProperty("email")
    private String email;
    public Nurse() {
    }

    public Nurse(int nurseId, String nurseName, String department, String phoneNumber, String email) {
        this.nurseId = nurseId;
        this.nurseName = nurseName;
        this.department = department;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    @Override
    public String toString() {
        return "Nurse{" +
                "nurseId=" + nurseId +
                ", nurseName='" + nurseName + '\'' +
                ", department='" + department + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
