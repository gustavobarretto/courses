package com.dh.app2av1.service;

import com.dh.app2av1.entity.Movie;

import java.util.List;

public interface MovieService {

    Movie create(Movie movie);
    Movie get(Long id);
    List<Movie> findByGenre(String genre);
    List<Movie> getAll();
    void delete(Long id);

}
