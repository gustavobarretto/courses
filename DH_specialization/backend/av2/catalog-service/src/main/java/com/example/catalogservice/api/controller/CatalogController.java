package com.example.catalogservice.api.controller;

import com.example.catalogservice.api.client.MovieServiceClient;
import com.example.catalogservice.api.client.dto.MovieDto;
import com.example.catalogservice.domain.model.Movie;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("catalog")
@AllArgsConstructor
public class CatalogController {

	private final MovieServiceClient serviceClient;
	private final RestTemplate restTemplate;
	private static final Logger logger = LoggerFactory.getLogger(CatalogController.class);

	@GetMapping("/{genre}")
	ResponseEntity<List<Movie>> getGenre(@PathVariable String genre) {
		logger.info("GET catalog/genre");
		return serviceClient.getMovieByGenre(genre);
	}

	@PostMapping
	ResponseEntity<Movie> create(@RequestBody MovieDto movie) {
		logger.info("POST catalog movie create");
		return serviceClient.create(movie);
	}
}
