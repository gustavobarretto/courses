package com.example.serieservice.serieservice.api.controller;

import com.example.serieservice.serieservice.api.service.SerieService;
import com.example.serieservice.serieservice.domain.model.Serie;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("serie")
@AllArgsConstructor
public class SerieController {

    private final SerieService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Serie serie) {
        return ResponseEntity.ok(service.create(serie));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

}
