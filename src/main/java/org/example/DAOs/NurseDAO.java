package org.example.DAOs;
import org.example.Connection.ConnectionPool;
import org.example.DAOsInterface.GenericDAO;
import org.example.Models.Nurse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NurseDAO implements GenericDAO<Nurse, Nurse> {

    private ConnectionPool connectionPool;
    private Connection connection;


    public NurseDAO() {
        // Create a connection
        connectionPool=ConnectionPool.getInstance(10);
    }

    public void conncection() {
        try {connection = connectionPool.getConnection();
            String url = "jdbc:mysql://localhost:3306/mydb1";
            String username = "root";
            String password = "Ba@2112#";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
    }

    @Override
    public Nurse getById(int id) {
        Nurse nurse = null;
        try {
            connection = connectionPool.getConnection();
            String query = "SELECT * FROM Nurse WHERE nurse_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nurse = new Nurse(rs.getInt("nurse_id"), rs.getString("name"),
                        rs.getString("department"), rs.getString("phone_number"),
                        rs.getString("email"));
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
        return nurse;
    }

    @Override
    public List<Nurse> getAll() {

        List<Nurse> nurseList = new ArrayList<>();
        try {
            connection = connectionPool.getConnection();
            String query = "SELECT * FROM Nurse";
            PreparedStatement ps =connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Nurse nurse = new Nurse(rs.getInt("nurse_id"), rs.getString("name"),
                        rs.getString("department"), rs.getString("phone_number"),
                        rs.getString("email"));
                nurseList.add(nurse);
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
        return nurseList;
    }

    @Override
    public void save(Nurse entity) {
        try {
            connection = connectionPool.getConnection();
            String query = "INSERT INTO Nurse (nurse_id, name, department, phone_number, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, entity.getNurseId());
            ps.setString(2, entity.getNurseName());
            ps.setString(3, entity.getDepartment());
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
    public void delete(Nurse entity) {
        try {connection = connectionPool.getConnection();
            String query = "DELETE FROM Nurse WHERE nurse_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, entity.getNurseId());
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
    public void update(Nurse entity) {
        try {
            connection = connectionPool.getConnection();
            String query = "UPDATE Nurse SET name = ?, department = ?, phone_number = ?, email = ? WHERE nurse_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, entity.getNurseName());
            ps.setString(2, entity.getDepartment());
            ps.setString(3, entity.getPhoneNumber());
            ps.setString(4, entity.getEmail());
            ps.setInt(5, entity.getNurseId());
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
