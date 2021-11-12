package com.example.Odonto.service;

import com.example.Odonto.model.Paciente;

import java.util.Map;

public interface OdontoService<T> {
    T salvar(T t);
    Map<Integer, T> buscarTodos();
    void deletar(Integer id);
    T buscarPorId(Integer id);
    T atualizar(T t);
}
