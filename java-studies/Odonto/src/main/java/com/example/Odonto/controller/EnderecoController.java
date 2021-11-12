package com.example.Odonto.controller;

import com.example.Odonto.model.Endereco;
import com.example.Odonto.model.Paciente;
import com.example.Odonto.service.impl.EnderecoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> salvarEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.salvar(endereco));
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Endereco>> buscarTodos() {
        return ResponseEntity.ok(enderecoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(enderecoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id) {
        enderecoService.deletar(id);
        return "Endereço deletado!";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizar(@PathVariable Integer id, @RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.atualizar(id, endereco));
    }
}
