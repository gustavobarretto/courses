package com.example.clinica.repository;

public interface IRepository<T> {
    T salvar(T t);
    T buscarPorId(Integer id);

}
