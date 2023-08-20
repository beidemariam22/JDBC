package org.example.DAOsInterface;

import java.util.List;

public interface GenericDAO <T,R>{
    public R getById(int entity) ;
    public List<R> getAll() ;
    public void save(T entity);
    public void delete(T entity);
    public void update(T entity);

}
