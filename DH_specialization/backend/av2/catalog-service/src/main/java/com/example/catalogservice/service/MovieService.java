package com.example.catalogservice.service;

import com.example.catalogservice.domain.model.Movie;

import java.util.List;

public interface MovieService {
    void save(Movie movie);
    List<Movie> getByNome(String nome);
}
