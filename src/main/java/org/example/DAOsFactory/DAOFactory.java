package org.example.DAOsFactory;

import org.example.DAOs.DepartmentDAO;
import org.example.DAOs.DoctorDAO;
import org.example.DAOs.NurseDAO;
import org.example.DAOs.PatientDAO;
import org.example.DAOsInterface.GenericDAO;

public class DAOFactory {
    public static  GenericDAO<?, ?> getDAO(String type) {
        if(type == null){
            return null;
        }
        if (type.equalsIgnoreCase("Department")) {
            return new DepartmentDAO();
        } else if (type.equalsIgnoreCase("Doctor")) {
            return new DoctorDAO();
        } else if (type.equalsIgnoreCase("Nurse")) {
            return new NurseDAO();
        } else if (type.equalsIgnoreCase("Patient")) {
            return new PatientDAO();
        } else {
            throw new IllegalArgumentException("Invalid DAO type: " + type);
        }
    }
}
