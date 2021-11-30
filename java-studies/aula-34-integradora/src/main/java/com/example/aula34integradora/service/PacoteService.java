package com.example.aula34integradora.service;

import com.example.aula34integradora.entities.PacoteEntity;
import com.example.aula34integradora.enums.StatusEnum;
import com.example.aula34integradora.repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;

    public PacoteEntity salvar(PacoteEntity pacote){
        return pacoteRepository.save(pacote);
    }

    public List<PacoteEntity> buscarTodos(){
        return pacoteRepository.findAll();
    }

    public List<PacoteEntity> buscarACaminho(){
        return  pacoteRepository.findAllByStatus(StatusEnum.A_CAMINHO);
    }

}
