package com.example.movieservice.api.controller;

import com.example.movieservice.api.service.MovieService;
import com.example.movieservice.domain.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
public class MovieController {

	@Autowired
	MovieService service;

	@GetMapping("/{genre}")
	ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
		return ResponseEntity.ok().body(service.findByGenre(genre));
	}

	@PostMapping("/salvar")
	ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
		return ResponseEntity.ok().body(service.save(movie));
	}
}
