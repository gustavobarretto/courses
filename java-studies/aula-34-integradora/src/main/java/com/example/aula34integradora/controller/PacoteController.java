package com.example.aula34integradora.controller;

import com.example.aula34integradora.entities.PacoteEntity;
import com.example.aula34integradora.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    @Autowired
    private PacoteService pacoteService;

    @PostMapping
    public ResponseEntity<PacoteEntity> salvar(@RequestBody PacoteEntity pacote){
        return ResponseEntity.ok(pacoteService.salvar(pacote));
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<PacoteEntity>> buscarTodos(){
        return ResponseEntity.ok(pacoteService.buscarTodos());
    }

    @GetMapping("/buscarCaminho")
    public ResponseEntity<List<PacoteEntity>> buscarCaminho(){
        return ResponseEntity.ok(pacoteService.buscarACaminho());
    }
}
