package org.example.Interfaces;

import org.example.Models.Patient;
import java.util.List;

public interface Patients {
    Patient getById(int id);
    List<Patient> getAll();
    void save(Patient patient);
    void delete(int id);
    void update(Patient patient);
}
