package com.dh.app3av2.app3av2.service;

import com.dh.app3av2.app3av2.entity.Serie;

import java.util.List;

public interface SerieService {

    Serie create(Serie serie);
    List<Serie> getAll();
}
