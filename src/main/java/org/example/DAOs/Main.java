package org.example.DAOs;

import org.example.DAOs.DepartmentDAO;
import org.example.DAOs.DoctorDAO;
import org.example.DAOs.NurseDAO;
import org.example.DAOs.PatientDAO;
import org.example.Models.Department;
import org.example.Models.Doctor;
import org.example.Models.Nurse;
import org.example.Models.Patient;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create DAO instances
        DepartmentDAO departmentDAO = new DepartmentDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        NurseDAO nurseDAO = new NurseDAO();
        PatientDAO patientDAO = new PatientDAO();

        // Retrieve all departments
        List<Department> allDepartments = departmentDAO.getAll();
        System.out.println("All Departments:");
        for (Department dept : allDepartments) {
            System.out.println(dept.getDepartmentName());
        }

        // Retrieve department by ID
        Department department = departmentDAO.getById(2);
        if (department != null) {
            System.out.println("Department with ID 1: " + department.getDepartmentName());
        }

        // Create a new department
        Department newDepartment = new Department(9, "Ophthalmology");
        departmentDAO.save(newDepartment);
        System.out.println("New department created: " + newDepartment.getDepartmentName());

        // Update an existing department
        Department departmentToUpdate = departmentDAO.getById(2);
        if (departmentToUpdate != null) {
            departmentToUpdate.setDepartmentName("Dermatology");
            departmentDAO.update(departmentToUpdate);
            System.out.println("Department updated: " + departmentToUpdate.getDepartmentName());
        }

        // Delete a department
        Department departmentToDelete = departmentDAO.getById(3);
        if (departmentToDelete != null) {
            departmentDAO.delete(departmentToDelete);
            System.out.println("Department deleted: " + departmentToDelete.getDepartmentName());
        }

        // Retrieve all doctors
        List<Doctor> allDoctors = doctorDAO.getAll();

        System.out.println("All Doctors:");
        for (Doctor doc : allDoctors) {
            System.out.println(doc.getDoctorName());
        }

        // Retrieve doctor by ID
        Doctor doctor = doctorDAO.getById(1);
        if (doctor != null) {
            System.out.println("Doctor with ID 1: " + doctor.getDoctorName());
        }

        // Create a new doctor
        Doctor newDoctor = new Doctor(6, "Dr. Smith","General Practitioner", "555-1234", "smith@gmail.com");
        doctorDAO.save(newDoctor);
        System.out.println("New doctor created: " + newDoctor.getDoctorName());

        // Update an existing doctor
        Doctor doctorToUpdate = doctorDAO.getById(2);
        if (doctorToUpdate != null) {
            doctorToUpdate.setDoctorQualification("Pediatrics");
            doctorDAO.update(doctorToUpdate);
            System.out.println("Doctor updated: " + doctorToUpdate.getDoctorName());
        }

        // Delete a doctor
        Doctor doctorToDelete = doctorDAO.getById(3);
        if (doctorToDelete != null) {
            doctorDAO.delete(doctorToDelete);
            System.out.println("Doctor deleted: " + doctorToDelete.getDoctorName());
        }

        // Retrieve all nurses
        List<Nurse> allNurses = nurseDAO.getAll();

        System.out.println("All Nurses:");
        for (Nurse nrs : allNurses) {
            System.out.println(nrs.getNurseName());
        }

        // Retrieve nurse by ID
        Nurse nurse = nurseDAO.getById(1);
        if (nurse != null) {
            System.out.println("Nurse with ID 1: " + nurse.getNurseName());
        }

        // Create a new nurse
        Nurse newNurse = new Nurse(11, "Emily", "Cardiology", "555-9876", "emily@gmail.com");
        nurseDAO.save(newNurse);
        System.out.println("New nurse created: " + newNurse.getNurseName());

        // Update an existing nurse
        Nurse nurseToUpdate = nurseDAO.getById(2);
        if (nurseToUpdate != null) {
            nurseToUpdate.setDepartment("Neurology");
            nurseDAO.update(nurseToUpdate);
            System.out.println("Nurse updated: " + nurseToUpdate.getNurseName());
        }

        // Delete a nurse
        Nurse nurseToDelete = nurseDAO.getById(3);
        if (nurseToDelete != null) {
           nurseDAO.delete(nurseToDelete);
           System.out.println("Nurse deleted: " + nurseToDelete.getNurseName());
        }

        // Retrieve all patients
        List<Patient> allPatients = patientDAO.getAll();

        System.out.println("All Patients:");
        for (Patient pat : allPatients) {
        System.out.println(pat.getPatientName());
        }

        // Retrieve patient by ID
        Patient patient = patientDAO.getById(1);
        if (patient != null) {
            System.out.println("Patient with ID 1: " + patient.getPatientName());
        }

        // Create a new patient
        Patient newPatient = new Patient(6, "Sarah", "1995-08-20", "Female", "456 Oak St", "555-4321", "sarah@gmail.com", nurse);
        patientDAO.save(newPatient);
        System.out.println("New patient created: " + newPatient.getPatientName());

        // Update an existing patient
        Patient patientToUpdate = patientDAO.getById(2);
        if (patientToUpdate != null) {
            patientToUpdate.setPhoneNumber("555-5678");
            patientDAO.update(patientToUpdate);
            System.out.println("Patient updated: " + patientToUpdate.getPatientName());
        }

        // Delete a patient
        Patient patientToDelete = patientDAO.getById(4);
        if (patientToDelete != null) {
            patientDAO.delete(patientToDelete);
            System.out.println("Patient deleted: " + patientToDelete.getPatientName());
        }
    }
}

