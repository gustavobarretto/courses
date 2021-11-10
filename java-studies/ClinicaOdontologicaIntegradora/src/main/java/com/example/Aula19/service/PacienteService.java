package com.example.Aula19.service;

import com.example.Aula19.model.Paciente;

import java.util.List;

public interface PacienteService {
    List<Paciente> buscarTodos();
    Paciente buscarPorEmail(String email);
}
