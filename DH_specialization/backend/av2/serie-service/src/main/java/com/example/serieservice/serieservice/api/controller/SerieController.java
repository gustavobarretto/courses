package com.example.serieservice.serieservice.api.controller;

import com.example.serieservice.serieservice.api.service.SerieService;
import com.example.serieservice.serieservice.domain.model.Serie;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("serie")
@AllArgsConstructor
public class SerieController {

    private final SerieService service;
    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(SerieController.class);

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Serie serie) {
        logger.info("POST at serie");
        return ResponseEntity.ok(service.create(serie));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        logger.info("GET at serie");
        return ResponseEntity.ok(service.getAll());
    }

}
