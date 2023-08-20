package org.example.Parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Models.Hospital;
import org.example.Models.Department;
import org.example.Models.Doctor;
import org.example.Models.Nurse;
import org.example.Models.Patient;

import java.io.File;
import java.io.IOException;

public class JacksonParser {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Parse the JSON file
            File file = new File("C:\\Users\\HP\\IdeaProjects\\JDBC\\src\\main\\resources\\Hospital.json");
            Hospital hospitalData = objectMapper.readValue(file, Hospital.class);

            // Access the parsed data
            for (Doctor doctor : hospitalData.getDoctors()) {
                System.out.println("Doctor ID: " + doctor.getDoctorId());
                System.out.println("Doctor Name: " + doctor.getDoctorName());
                System.out.println("Doctor Qualification: " + doctor.getDoctorQualification());
                System.out.println("Doctor Phone Number: " + doctor.getPhoneNumber());
                System.out.println("Doctor Email: " + doctor.getEmail());
                System.out.println();
            }

            for (Nurse nurse : hospitalData.getNurses()) {
                System.out.println("Nurse ID: " + nurse.getNurseId());
                System.out.println("Nurse Name: " + nurse.getNurseName());
                System.out.println("Nurse Department: " + nurse.getDepartment());
                System.out.println("Nurse Phone Number: " + nurse.getPhoneNumber());
                System.out.println("Nurse Email: " + nurse.getEmail());
                System.out.println();
            }

            for (Patient patient : hospitalData.getPatients()) {
                System.out.println("Patient ID: " + patient.getPatientId());
                System.out.println("Patient Name: " + patient.getPatientName());
                System.out.println("Patient Date of Birth: " + patient.getPatientDateOfBirth());
                System.out.println("Patient Gender: " + patient.getPatientGender());
                System.out.println("Patient Address: " + patient.getPatientAddress());
                System.out.println("Patient Phone Number: " + patient.getPhoneNumber());
                System.out.println("Patient Email: " + patient.getPatientEmail());
                //System.out.println("Assigned Nurse ID: " + patient.getNurseId());
                System.out.println();
            }

            for (Department department : hospitalData.getDepartments()) {
                System.out.println("Department ID: " + department.getDepartmentId());
                System.out.println("Department Name: " + department.getDepartmentName());
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
