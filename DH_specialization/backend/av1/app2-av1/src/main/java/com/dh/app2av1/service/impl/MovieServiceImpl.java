package com.dh.app2av1.service.impl;

import com.dh.app2av1.entity.Movie;
import com.dh.app2av1.repository.MovieRepository;
import com.dh.app2av1.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;

    @Override
    public Movie create(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public Movie get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Movie> findByGenre(String genre) {
        return repository.findByGenre(genre);
    }

    @Override
    public List<Movie> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {

    }
}
