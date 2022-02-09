package com.example.javachallenge.controller;

import com.example.javachallenge.model.Film;
import com.example.javachallenge.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @PostMapping("/create")
    public ResponseEntity<Film> create(@RequestBody Film film) {
        Film filmeCreated = filmService.create(film);
        return ResponseEntity.ok(film);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        filmService.delete(id);
        Film checkingDelete = filmService.get(id);
        if(checkingDelete == null) {
            return ResponseEntity.ok("Film successfully deleted.");
        }
        return ResponseEntity.ok("Film not found for delete or film not deleted.");
    }

    @PutMapping("/update")
    public ResponseEntity<Film> update(@RequestBody Film film) {
        Film filmUpdated = filmService.update(film);
        return ResponseEntity.ok(filmUpdated);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Film> get(@PathVariable Integer id) {
        Film filmGetted = filmService.get(id);
        return ResponseEntity.ok(filmGetted);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Film>> get() {
        return ResponseEntity.ok(filmService.getAll());
    }
}
