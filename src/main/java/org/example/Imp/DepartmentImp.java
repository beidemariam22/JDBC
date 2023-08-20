package org.example.Imp;

import org.apache.ibatis.session.SqlSession;
import org.example.Interfaces.Departments;
import org.example.Models.Department;
import java.util.List;

public class DepartmentImp implements Departments {
    private final SqlSession sqlSession;

    public DepartmentImp(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Department getById(int id) {
        return sqlSession.selectOne("MapperXml.DepartmentMapper.getById", id);
    }

    @Override
    public List<Department> getAll() {
        return sqlSession.selectList("MapperXml.DepartmentMapper.getAll");
    }

    @Override
    public void save(Department department) {
        sqlSession.insert("MapperXml.DepartmentMapper.save", department);
    }

    @Override
    public void delete(int id) {
        sqlSession.delete("MapperXml.DepartmentMapper.delete", id);
    }

    @Override
    public void update(Department department) {
        sqlSession.update("MapperXml.DepartmentMapper.update", department);
    }
}
