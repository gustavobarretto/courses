package com.example.clinica_odontologica_2.service.impl;

import com.example.clinica_odontologica_2.model.Consulta;
import com.example.clinica_odontologica_2.repository.impl.ConsultaRepositoryImpl;
import com.example.clinica_odontologica_2.service.OdontoService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConsultaServiceImpl implements OdontoService<Consulta> {
    private ConsultaRepositoryImpl consultaRepository;

    public ConsultaServiceImpl() {
        this.consultaRepository = new ConsultaRepositoryImpl();
    }


    @Override
    public Consulta salvar(Consulta consulta) {
        return consultaRepository.salvar(consulta);
    }

    @Override
    public Consulta buscarPorId(Integer id) {
        return consultaRepository.buscarPorId(id);
    }

    @Override
    public void deletar(Integer id) {
        consultaRepository.deletar(id);
    }

    @Override
    public Map<Integer, Consulta> buscarTodos() {
        return consultaRepository.buscarTodos();
    }

    @Override
    public Consulta atualizar(Integer id, Consulta consulta) {
        return consultaRepository.atualizar(id, consulta);
    }
}
