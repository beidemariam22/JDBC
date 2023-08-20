package org.example.Parsers;

import org.example.Models.Hospital;
import org.example.Models.Department;
import org.example.Models.Doctor;
import org.example.Models.Nurse;
import org.example.Models.Patient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class JAXBParser {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\HP\\IdeaProjects\\JDBC\\src\\main\\resources\\Hospital.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Hospital.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            String path = "suppliers.xml";
            BufferedReader reader = new BufferedReader(new FileReader(file));

            Hospital hospital = (Hospital) jaxbUnmarshaller.unmarshal(reader);

            // Access the parsed hospital data and perform further operations
            List<Department> departments = hospital.getDepartments();
            List<Doctor> doctors = hospital.getDoctors();
            List<Nurse> nurses = hospital.getNurses();
            List<Patient> patients = hospital.getPatients();

            // Print department names
            System.out.println("Departments:");
            for (Department department : departments) {
                System.out.println("Department ID: " + department.getDepartmentId());
                System.out.println("Department Name: " + department.getDepartmentName());
                System.out.println();
            }

            //Print nurse names
            System.out.println("Nurses");
            for(Nurse nurse : nurses){
                System.out.println("Nurse ID: " + nurse.getNurseId());
                System.out.println("Nurse Name: " + nurse.getNurseName());
                System.out.println("Division: " + nurse.getDepartment());
                System.out.println("Nurse PhoneNumber: " + nurse.getPhoneNumber());
                System.out.println("Nurse Email: " + nurse.getEmail());
                System.out.println();
            }

            //Print doctor names
            for(Doctor doctor : doctors){
                System.out.println("Doctor ID: " + doctor.getDoctorId());
                System.out.println("Doctor Name: " + doctor.getDoctorName());
                System.out.println("Doctor Qualification: " + doctor.getDoctorQualification());
                System.out.println("Doctor PhoneNumber: " + doctor.getPhoneNumber());
                System.out.println("Doctor Email: " + doctor.getEmail());
                System.out.println();
            }

            //Print patient names
            for(Patient patient : patients){
                System.out.println("Patient ID: " + patient.getPatientId());
                System.out.println("Patient Name: " + patient.getPatientName());
                System.out.println("Patient Date of Birth: " + patient.getPatientDateOfBirth() );
                System.out.println("Patient Gender: " + patient.getPatientGender());
                System.out.println("Patient Address: " + patient.getPatientAddress());
                System.out.println("Patient PhoneNumber: " + patient.getPhoneNumber());
                System.out.println("Patient Email: " + patient.getPatientEmail());
                System.out.println("Patient Email: " + patient. getNurses());
                System.out.println();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
