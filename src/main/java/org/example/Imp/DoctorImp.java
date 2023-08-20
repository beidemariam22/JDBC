package org.example.Imp;
import org.apache.ibatis.session.SqlSession;
import org.example.Interfaces.Doctors;
import org.example.Models.Doctor;
import java.util.List;

public class DoctorImp implements Doctors {
    private final SqlSession sqlSession;

    public DoctorImp(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Doctor getById(int id) {
        return sqlSession.selectOne("MapperXml.DoctorMapper.getById", id);
    }

    @Override
    public List<Doctor> getAll() {
        return sqlSession.selectList("MapperXml.DoctorMapper.getAll");
    }

    @Override
    public void save(Doctor doctor) {
        sqlSession.insert("MapperXml.DoctorMapper.save", doctor);
    }

    @Override
    public void delete(int id) {
        sqlSession.delete("MapperXml.DoctorMapper.delete", id);
    }

    @Override
    public void update(Doctor doctor) {
        sqlSession.update("MapperXml.DoctorMapper.update", doctor);
    }
}
