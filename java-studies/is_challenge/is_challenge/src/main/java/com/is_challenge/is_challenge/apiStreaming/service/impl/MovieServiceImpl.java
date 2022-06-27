package com.is_challenge.is_challenge.apiStreaming.service.impl;

import com.is_challenge.is_challenge.apiStreaming.entity.Movie;
import com.is_challenge.is_challenge.apiStreaming.exception.MovieNotFoundException;
import com.is_challenge.is_challenge.apiStreaming.repository.MovieRepository;
import com.is_challenge.is_challenge.apiStreaming.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;


    @Override
    public Movie create(Movie movie) {
        System.out.println(movie.toString());
        return repository.save(movie);
    }

    @Override
    public List<Movie> getAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Movie getById(Long id) {
        return repository.findById(id).orElseThrow( () -> new MovieNotFoundException("Movie with id " + id + " not found!"));
    }
}
