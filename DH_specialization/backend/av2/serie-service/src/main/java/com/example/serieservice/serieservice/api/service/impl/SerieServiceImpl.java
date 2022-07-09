package com.example.serieservice.serieservice.api.service.impl;

import com.example.serieservice.serieservice.api.service.SerieService;
import com.example.serieservice.serieservice.domain.exception.SerieNotFoundException;
import com.example.serieservice.serieservice.domain.model.Serie;
import com.example.serieservice.serieservice.domain.repository.SerieRepository;
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

    @Override
    public Serie getById(String id) {
        return repository.findById(id).orElseThrow( () -> new SerieNotFoundException(id));
    }

    @Override
    public void delete(String id) {
        repository.findById(id).orElseThrow( () -> new SerieNotFoundException(id));
        repository.deleteById(id);
    }
}
