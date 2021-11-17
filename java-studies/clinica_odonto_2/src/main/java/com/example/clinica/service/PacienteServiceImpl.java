package com.example.clinica.service;

import com.example.clinica.model.Paciente;
import com.example.clinica.repository.impl.PacienteRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements OdontoService<Paciente> {

    @Autowired
    private PacienteRepositoryImpl pacienteRepository;


    @Override
    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.salvar(paciente);
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        return pacienteRepository.buscarPorId(id);
    }
}
