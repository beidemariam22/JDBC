package org.example.Imp;


import org.apache.ibatis.session.SqlSession;
import org.example.Interfaces.Nurses;
import org.example.Models.Nurse;
import java.util.List;

public class NurseImp implements Nurses {
    private final SqlSession sqlSession;

    public NurseImp(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Nurse getById(int id) {
        return sqlSession.selectOne("MapperXml.NurseMapper.getById", id);
    }

    @Override
    public List<Nurse> getAll() {
        return sqlSession.selectList("MapperXml.NurseMapper.getAll");
    }

    @Override
    public void save(Nurse nurse) {
        sqlSession.insert("MapperXml.NurseMapper.save", nurse);
    }

    @Override
    public void delete(int id) {
        sqlSession.delete("MapperXml.NurseMapper.delete", id);
    }

    @Override
    public void update(Nurse nurse) {
        sqlSession.update("MapperXml.NurseMapper.update", nurse);
    }
}

