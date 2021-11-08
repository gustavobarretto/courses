package dao;

import java.util.List;

public interface IDao <T> {

//    CRUD
    public T save(T t);
    public T search(Integer id);
    public List<T> searchAll();
    public void delete(T t); // Ainda verificando a possibilidade de ser um Integer id ao invés de um objeto
    public Integer update(String name, Integer id); //
}
