package com.example.movimento.service;

import com.example.movimento.persistence.entities.MovimentoEntity;
import com.example.movimento.persistence.respository.MovimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentoService {

    @Autowired
    MovimentoRepository movimentoRepository;

    public String save(MovimentoEntity movimento) {
        if(movimentoRepository.save(movimento) != null)
            return "OK";
        return null;
    }

    public List<MovimentoEntity> obterTodos() {
        return movimentoRepository.findAll();
    }
}
