package org.example.DAOs;

import org.example.Connection.ConnectionPool;
import org.example.Models.Department;
import org.example.DAOsInterface.GenericDAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DepartmentDAO implements GenericDAO<Department,Department> {

    private ConnectionPool connectionPool;
    private Connection connection;
    public DepartmentDAO(){
        connectionPool = ConnectionPool.getInstance(10);
    }
    @Override
    public Department getById(int departmentId) {
        Department department =null;
        try {
            connection = connectionPool.getConnection();
            String query = "SELECT department_id, department_name FROM Department WHERE department_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, departmentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                department = new Department(rs.getInt("department_id"), rs.getString("department_name"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
        return department;
    }

    @Override
    public List<Department> getAll() {
        List<Department> departmentList = new ArrayList<>();
        try {
            connection = connectionPool.getConnection();
            String query = "SELECT department_id, department_name FROM Department";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department(rs.getInt("department_id"), rs.getString("department_name"));
                departmentList.add(department);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
        return departmentList;
    }

    @Override
    public void save(Department department) {
        try {
            connection = connectionPool.getConnection();
            String query = "INSERT INTO Department (department_id, department_name) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, department.getDepartmentId());
            ps.setString(2, department.getDepartmentName());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
    }
    @Override
    public void delete(Department department) {
        try {
            connection = connectionPool.getConnection();
            String query = "DELETE FROM Department WHERE department_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, department.getDepartmentId());
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
    public void update(Department department) {
        try {
            connection = connectionPool.getConnection();
            String query = "UPDATE Department SET department_name = ? WHERE department_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, department.getDepartmentName());
            ps.setInt(32, department.getDepartmentId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            if (connection != null) {
                connectionPool.releaseConnection(connection);
            }
        }
    }

}
