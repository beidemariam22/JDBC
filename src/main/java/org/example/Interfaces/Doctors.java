package org.example.Interfaces;

import org.example.Models.Doctor;
import java.util.List;

public interface Doctors {
    Doctor getById(int id);
    List<Doctor> getAll();
    void save(Doctor doctor);
    void delete(int id);
    void update(Doctor doctor);
}