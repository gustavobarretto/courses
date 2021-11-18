package com.example.clinica_odontologica_2.service;

import org.springframework.stereotype.Service;

import java.util.Map;

public interface OdontoService<T> {
    T salvar(T t);
    T buscarPorId(Integer id);
    void deletar(Integer id);
    Map<Integer, T> buscarTodos();
    T atualizar(Integer id, T t);
}
