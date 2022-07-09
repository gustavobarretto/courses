package com.dh.app3av2.app3av2.controller;

import com.dh.app3av2.app3av2.entity.Serie;
import com.dh.app3av2.app3av2.service.SerieService;
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
