package com.example.clinica_odontologica_2.repository;

public interface IRepository<T> {
    T salvar(T t);
    T buscarPorId(Integer id);
}
