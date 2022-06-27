package com.is_challenge.is_challenge.apiStreaming.controller;

import com.is_challenge.is_challenge.apiStreaming.dto.ScoreDTO;
import com.is_challenge.is_challenge.apiStreaming.entity.Score;
import com.is_challenge.is_challenge.apiStreaming.service.ScoreService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("scores")
@AllArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ScoreDTO dto) {
        scoreService.create(modelMapper.map(dto, Score.class));
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Score> get(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(scoreService.get(id));
    }
}
