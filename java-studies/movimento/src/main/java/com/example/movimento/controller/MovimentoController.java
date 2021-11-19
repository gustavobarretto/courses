package com.example.movimento.controller;

import com.example.movimento.persistence.entities.MovimentoEntity;
import com.example.movimento.service.MovimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentos")
public class MovimentoController {

    @Autowired
    MovimentoService movimentoService;

    @PostMapping("/salvar")
    public ResponseEntity<String> salvar(@RequestBody MovimentoEntity movimento) {
        ResponseEntity<String> response = null;

        if(movimentoService.save(movimento) != null)
            response = ResponseEntity.ok("Movimento salvo com sucesso");
        else
            response = ResponseEntity.internalServerError().body("Deu ruim");

        return response;
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<MovimentoEntity>> buscarTodos() {
        return ResponseEntity.ok(movimentoService.obterTodos());
    }
}
