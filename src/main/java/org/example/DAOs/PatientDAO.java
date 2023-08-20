package org.example.DAOs;

import org.example.Connection.ConnectionPool;
import org.example.DAOsInterface.GenericDAO;
import org.example.Models.Nurse;
import org.example.Models.Patient;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class PatientDAO implements GenericDAO<Patient, Patient> {

    private ConnectionPool connectionPool;
    private Connection connection;

    public PatientDAO() {
        // Create a connection pool with a maximum pool size of 10
        connectionPool = ConnectionPool.getInstance(10);
    }

    @Override
    public Patient getById(int id) {
        Patient patient = null;
        try {
            connection = connectionPool.getConnection();

            String query = "SELECT * FROM Patient WHERE patient_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Retrieve the nurse associated with the patient
                int nurseId = rs.getInt("Nurse_nurse_id");
                NurseDAO nurseDAO = new NurseDAO();
                Nurse nurse = nurseDAO.getById(nurseId);

                patient = new Patient(rs.getInt("patient_id"), rs.getString("name"),
                        rs.getString("date_of_birth"), rs.getString("gender"),
                        rs.getString("address"), rs.getString("phone_number"),
                        rs.getString("email"), nurse);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
        return patient;
    }

    @Override
    public List<Patient> getAll(){
        List<Patient> patientList = new ArrayList<>();
        try {
            connection = connectionPool.getConnection();

            String query = "SELECT * FROM Patient";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Retrieve the nurse associated with each patient
                int nurseId = rs.getInt("Nurse_nurse_id");
                NurseDAO nurseDAO = new NurseDAO();
                Nurse nurse = nurseDAO.getById(nurseId);

                Patient patient = new Patient(rs.getInt("patient_id"), rs.getString("name"),
                        rs.getString("date_of_birth"), rs.getString("gender"),
                        rs.getString("address"), rs.getString("phone_number"),
                        rs.getString("email"), nurse);
                patientList.add(patient);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
        return patientList;
    }

    @Override
    public void save(Patient entity) {
        try {
            connection = connectionPool.getConnection();

            String query = "INSERT INTO Patient (patient_id, name, date_of_birth, gender, address, phone_number, email, Nurse_nurse_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, entity.getPatientId());
            ps.setString(2, entity.getPatientName());
            ps.setString(3, entity.getPatientDateOfBirth());
            ps.setString(4, entity.getPatientGender());
            ps.setString(5, entity.getPatientAddress());
            ps.setString(6, entity.getPhoneNumber());
            ps.setString(7, entity.getPatientEmail());
            ps.setInt(8, entity.getNurses().getNurseId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
    }

    @Override
    public void delete(Patient entity) {
        try {
            connection = connectionPool.getConnection();

            String query = "DELETE FROM Patient WHERE patient_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, entity.getPatientId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
    }

    @Override
    public void update(Patient entity) {
        try {
            connection = connectionPool.getConnection();

            String query = "UPDATE Patient SET name = ?, date_of_birth = ?, gender = ?, address = ?, " +
                    "phone_number = ?, email = ?, Nurse_nurse_id = ? WHERE patient_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, entity.getPatientName());
            ps.setString(2, entity.getPatientDateOfBirth());
            ps.setString(3, entity.getPatientGender());
            ps.setString(4, entity.getPatientAddress());
            ps.setString(5, entity.getPhoneNumber());
            ps.setString(6, entity.getPatientEmail());
            ps.setInt(7, entity.getNurses().getNurseId());
            ps.setInt(8, entity.getPatientId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
    }
}
