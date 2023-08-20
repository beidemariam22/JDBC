package org.example.DAOs;

import org.example.Connection.ConnectionPool;
import org.example.Models.Doctor;
import org.example.DAOsInterface.GenericDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO implements GenericDAO<Doctor, Doctor> {

    private ConnectionPool connectionPool;
    private Connection connection;

    public DoctorDAO() {
        // Create a connection
        connectionPool=ConnectionPool.getInstance(10);
    }


    @Override
    public Doctor getById(int id) {
        Doctor doctor = null;
        try {connection = connectionPool.getConnection();
            String query = "SELECT * FROM Doctor WHERE doctor_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                doctor = new Doctor(rs.getInt("doctor_id"), rs.getString("name"),
                        rs.getString("qualification"), rs.getString("phone_number"), rs.getString("email"));
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
        return doctor;
    }

    @Override
    public List<Doctor> getAll() {
        List<Doctor> doctorList = new ArrayList<>();
        try {
            connection = connectionPool.getConnection();
            String query = "SELECT * FROM Doctor";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Doctor doctor = new Doctor(rs.getInt("doctor_id"), rs.getString("name"),
                        rs.getString("qualification"), rs.getString("phone_number"), rs.getString("email"));
                doctorList.add(doctor);
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
        return doctorList;
    }

    @Override
    public void save(Doctor entity) {
        try {
            connection = connectionPool.getConnection();
            String query = "INSERT INTO Doctor (doctor_id, name, qualification, phone_number, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, entity.getDoctorId());
            ps.setString(2, entity.getDoctorName());
            ps.setString(3, entity.getDoctorQualification());
            ps.setString(4, entity.getPhoneNumber());
            ps.setString(5, entity.getEmail());
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
    public void delete(Doctor entity) {
        try {
            connection = connectionPool.getConnection();
            String query = "DELETE FROM Doctor WHERE doctor_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, entity.getDoctorId());
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
    public void update(Doctor entity) {
        try {
            connection = connectionPool.getConnection();
            String query = "UPDATE Doctor SET name = ?, qualification = ?, phone_number = ?, email = ? WHERE doctor_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, entity.getDoctorName());
            ps.setString(2, entity.getDoctorQualification());
            ps.setString(3, entity.getPhoneNumber());
            ps.setString(4, entity.getEmail());
            ps.setInt(5, entity.getDoctorId());
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
