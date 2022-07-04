package com.dh.app3av2.app3av2.service.impl;

import com.dh.app3av2.app3av2.entity.Serie;
import com.dh.app3av2.app3av2.repository.SerieRepository;
import com.dh.app3av2.app3av2.service.SerieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SerieServiceImpl implements SerieService {

    private final SerieRepository repository;

    @Override
    public Serie create(Serie serie) {
        return repository.save(serie);
    }

    @Override
    public List<Serie> getAll() {
        return repository.findAll();
    }
}
