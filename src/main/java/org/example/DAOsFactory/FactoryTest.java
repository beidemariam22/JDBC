package org.example.DAOsFactory;

import org.example.DAOsInterface.GenericDAO;

public class FactoryTest {


    public static void main(String[] args) {

        // Use the factory to get DAO instances
        GenericDAO<?, ?> departmentDAO = DAOFactory.getDAO("Department");
        GenericDAO<?, ?> doctorDAO = DAOFactory.getDAO("Doctor");
        GenericDAO<?, ?> nurseDAO = DAOFactory.getDAO("Nurse");
        GenericDAO<?, ?> patientDAO = DAOFactory.getDAO("Patient");

        // Use the DAO methods
        // Now you can use the retrieved objects as needed
        System.out.println("Department: " + departmentDAO.getById(1));
        System.out.println("Departments: " + departmentDAO.getAll());

        System.out.println("Doctor: " + doctorDAO.getById(1));
        System.out.println("Doctors: " + doctorDAO.getAll());

        System.out.println("Nurse: " + nurseDAO.getById(1));
        System.out.println("Nurses: " + nurseDAO.getAll());

        System.out.println("Patient: " +  patientDAO.getById(1));
        System.out.println("Patients: " + patientDAO.getAll());
    }
}

