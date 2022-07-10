package com.example.movieservice.api.controller;

import com.example.movieservice.api.dto.MovieDto;
import com.example.movieservice.api.service.impl.MovieServiceImpl;
import com.example.movieservice.domain.model.Movie;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RefreshScope
@RestController
@AllArgsConstructor
@RequestMapping("movie")
public class MovieController {


	private final MovieServiceImpl service;
	private final ModelMapper mapper;
	private final RestTemplate restTemplate;
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);


	@GetMapping("/{genre}")
	ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
		logger.info("GET genre at movie");
		return ResponseEntity.ok().body(service.findByGenre(genre));
	}

	@PostMapping
	ResponseEntity<Movie> create(@RequestBody MovieDto movie) {
		logger.info("POST movie at movie service");
		return ResponseEntity.ok().body(service.create(
				mapper.map(movie, Movie.class)
		));
	}

	@GetMapping
	ResponseEntity<List<MovieDto>> getAll() {
		return ResponseEntity
				.ok()
				.body(
						service
								.getAll()
								.stream()
								.map(m -> mapper.map(m, MovieDto.class))
								.collect(Collectors.toList())
				);
	}
}
