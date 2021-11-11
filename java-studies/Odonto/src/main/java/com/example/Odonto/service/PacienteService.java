package com.example.Odonto.service;

import com.example.Odonto.model.Paciente;

import java.util.Map;

public interface PacienteService {
    Paciente criarPaciente();
    Map<Integer, Paciente> buscarPacientes();
    void deletar(Integer id);
    Paciente buscarPorId(Integer id);
    Paciente atualizarPaciente(Integer id, String nome);
}
