package org.example.BuilderPattern;

import org.example.Models.*;

public class BuilderTest {

    public static void main(String[] args){
        Department department = new DepartmentBuilder()
                .departmentId(1)
                .departmentName("Cardiology")
                .Build();

        System.out.println(department);

        Doctor doctor = new DoctorBuilder()
                .doctorId(1)
                .doctorName("John Doe")
                .doctorQualification("MD")
                .phoneNumber("1234567890")
                .email("johndoe@example.com")
                .Build();
        System.out.println(doctor);

        Nurse nurse = new NurseBuilder()
                .nurseId(1)
                .nurseName("Jane Smith")
                .department("Cardiology")
                .phoneNumber("0987654321")
                .email("janesmith@example.com")
                .Build();
        System.out.println(nurse);

        Patient patient = new PatientBuilder()
                .patientId(1)
                .patientName("Alice Johnson")
                .patientDateOfBirth("1990-01-01")
                .patientGender("Female")
                .patientAddress("123 Main St")
                .phoneNumber("555-1234")
                .patientEmail("alice@example.com")
                .nurses(nurse)
                .Build();
        System.out.println(patient);

    }

}
