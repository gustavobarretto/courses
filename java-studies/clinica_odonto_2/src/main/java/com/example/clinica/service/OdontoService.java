package com.example.clinica.service;

public interface OdontoService<T> {
    T salvar(T t);
    T buscarPorId(Integer id);
}
