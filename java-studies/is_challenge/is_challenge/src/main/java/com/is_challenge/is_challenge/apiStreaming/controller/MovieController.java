package com.is_challenge.is_challenge.apiStreaming.controller;

import com.is_challenge.is_challenge.apiStreaming.dto.MovieDTO;
import com.is_challenge.is_challenge.apiStreaming.entity.Movie;
import com.is_challenge.is_challenge.apiStreaming.service.MovieService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movies")
@AllArgsConstructor
public class MovieController {

    private final MovieService service;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody MovieDTO dto) {
        System.out.println(dto.toString());
        service.create(modelMapper.map(dto, Movie.class));
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieDTO> get(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        modelMapper.map(service.getById(id), MovieDTO.class)
                );
    }
}
