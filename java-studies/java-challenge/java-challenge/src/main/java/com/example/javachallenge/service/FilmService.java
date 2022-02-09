package com.example.javachallenge.service;

import com.example.javachallenge.model.Film;
import com.example.javachallenge.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public Film create(Film film) {
        return filmRepository.save(film);
    }

    public void delete(Integer id) {
        filmRepository.deleteById(id);
    }

    public Film update(Film film) {
        return filmRepository.saveAndFlush(film);
    }

    public Film get(Integer id) {
        return filmRepository.findById(id).get();
    }

    public List<Film> getAll() {
        return filmRepository.findAll();
    }



}
