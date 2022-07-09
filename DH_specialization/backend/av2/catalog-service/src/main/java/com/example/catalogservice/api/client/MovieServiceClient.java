package com.example.catalogservice.api.client;

import com.example.catalogservice.domain.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient (name="movie-service", url="api-gateway:8080/movies")
public interface MovieServiceClient {

	@GetMapping("/{genre}")
	ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable(value = "genre") String genre);

	@PostMapping("/salvar")
	ResponseEntity<Movie> saveMovie(@RequestBody Movie movie);

}
