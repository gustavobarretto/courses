package dao;

public interface IDao <T>{
    public T salvar(T t);
    public T buscar();
}
