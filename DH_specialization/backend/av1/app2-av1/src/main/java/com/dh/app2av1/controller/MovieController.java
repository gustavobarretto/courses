package com.dh.app2av1.controller;

import com.dh.app2av1.dto.MovieDTO;
import com.dh.app2av1.entity.Movie;
import com.dh.app2av1.service.MovieService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    private final MovieService service;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody MovieDTO dto) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .header("Location", "/movie/" + service.create(mapper.map(dto, Movie.class)).getId())
                .build();
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieDTO> get(@RequestParam Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapper.map(service.get(id), MovieDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        service.getAll().stream().map(m -> mapper.map(m, MovieDTO.class)).collect(Collectors.toList())
                );
    }

    @GetMapping("filter/{genre}")
    public ResponseEntity<List<MovieDTO>> getByGenre(@PathVariable String genre) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        service.findByGenre(genre).stream().map(m -> mapper.map(m, MovieDTO.class)).collect(Collectors.toList())
                );
    }
}
