package com.example.serieservice.serieservice.api.service;

import com.example.serieservice.serieservice.domain.model.Serie;

import java.util.List;

public interface SerieService {

    Serie create(Serie serie);
    List<Serie> getAll();
    Serie getById(String id);
    void delete(String id);
}
