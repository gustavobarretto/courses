package com.example.clinica_odontologica_2.service;

import org.springframework.stereotype.Service;

public interface OdontoService<T> {
    T salvar(T t);
    T buscarPorId(Integer id);
}
