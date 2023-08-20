package org.example.Interfaces;

import org.example.Models.Nurse;
import java.util.List;

public interface Nurses {
    Nurse getById(int id);
    List<Nurse> getAll();
    void save(Nurse nurse);
    void delete(int id);
    void update(Nurse nurse);
}
