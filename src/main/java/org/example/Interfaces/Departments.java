package org.example.Interfaces;
import org.example.Models.Department;

import java.util.List;

public interface Departments {
    Department getById(int id);
    List<Department> getAll();
    void save(Department department);
    void delete(int id);
    void update(Department department);
}
