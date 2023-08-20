package org.example.Imp;

import org.apache.ibatis.session.SqlSession;
import org.example.Interfaces.Patients;
import org.example.Models.Patient;
import java.util.List;

public class PatientImp implements Patients {
    private final SqlSession sqlSession;

    public PatientImp(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Patient getById(int id) {
        return sqlSession.selectOne("MapperXml.PatientMapper.getById", id);
    }

    @Override
    public List<Patient> getAll() {
        return sqlSession.selectList("MapperXml.PatientMapper.getAll");
    }

    @Override
    public void save(Patient patient) {
        sqlSession.insert("MapperXml.PatientMapper.save", patient);
    }

    @Override
    public void delete(int id) {
        sqlSession.delete("MapperXml.PatientMapper.delete", id);
    }

    @Override
    public void update(Patient patient) {
        sqlSession.update("MapperXml.PatientMapper.update", patient);
    }
}
