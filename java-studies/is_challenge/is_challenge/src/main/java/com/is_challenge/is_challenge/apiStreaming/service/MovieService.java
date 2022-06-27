package com.is_challenge.is_challenge.apiStreaming.service;

import com.is_challenge.is_challenge.apiStreaming.entity.Movie;

import java.util.List;

public interface MovieService {

    Movie create(Movie movie);
    List<Movie> getAll();
    void delete(Long id);
    Movie getById(Long id);
}
