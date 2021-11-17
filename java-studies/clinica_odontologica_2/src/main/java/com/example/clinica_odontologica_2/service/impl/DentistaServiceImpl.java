package com.example.clinica_odontologica_2.service.impl;

import com.example.clinica_odontologica_2.model.Dentista;
import com.example.clinica_odontologica_2.repository.impl.DentistaRepositoryImpl;
import com.example.clinica_odontologica_2.service.OdontoService;
import org.springframework.stereotype.Service;

@Service
public class DentistaServiceImpl implements OdontoService<Dentista> {
    private DentistaRepositoryImpl dentistaRepository;

    public DentistaServiceImpl() {
        this.dentistaRepository = new DentistaRepositoryImpl();
    }

    @Override
    public Dentista salvar(Dentista dentista) {
        return dentistaRepository.salvar(dentista);
    }

    @Override
    public Dentista buscarPorId(Integer id) {
        return dentistaRepository.buscarPorId(id);
    }
}
