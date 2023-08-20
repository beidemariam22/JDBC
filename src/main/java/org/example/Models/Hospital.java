package org.example.Models;

import org.example.Models.Department;
import org.example.Models.Doctor;
import org.example.Models.Nurse;
import org.example.Models.Patient;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "hospital")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hospital {
    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    private List<Department> departments;

    @XmlElementWrapper(name = "doctors")
    @XmlElement(name = "doctor")
    private List<Doctor> doctors;

    @XmlElementWrapper(name = "nurses")
    @XmlElement(name = "nurse")
    private List<Nurse> nurses;

    @XmlElementWrapper(name = "patients")
    @XmlElement(name = "patient")
    private List<Patient> patients;

    public Hospital() {
    }

    public Hospital(List<Department> departments, List<Doctor> doctors, List<Nurse> nurses, List<Patient> patients) {
        this.departments = departments;
        this.doctors = doctors;
        this.nurses = nurses;
        this.patients = patients;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
