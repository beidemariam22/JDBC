package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.Imp.*;
import org.example.Interfaces.Departments;
import org.example.Interfaces.Doctors;
import org.example.Interfaces.Nurses;
import org.example.Interfaces.Patients;
import org.example.Models.*;

public class Main {
    public static void main(String[] args) {
        // Create a MyBatis session

        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();

        // Create DAO instances
        Departments departmentDAO = new DepartmentImp(sqlSession);
        Doctors doctorDAO = new DoctorImp(sqlSession);
        Nurses nurseDAO = new NurseImp(sqlSession);
        Patients patientDAO = new PatientImp(sqlSession);

        // Example usage
        int departmentId = 1;
        Department department = departmentDAO.getById(departmentId);
        System.out.println("Department: " + department);

        int doctorId = 1;
        Doctor doctor = doctorDAO.getById(doctorId);
        System.out.println("Doctor: " + doctor);

        int nurseId = 1;
        Nurse nurse = nurseDAO.getById(nurseId);
        System.out.println("Nurse: " + nurse);

        int patientId = 1;
        Patient patient = patientDAO.getById(patientId);
        System.out.println("Patient: " + patient);

        // Close the MyBatis session
        sqlSession.close();
    }
}
