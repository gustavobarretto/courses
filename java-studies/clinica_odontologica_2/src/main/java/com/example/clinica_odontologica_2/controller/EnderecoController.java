package com.example.clinica_odontologica_2.controller;

import com.example.clinica_odontologica_2.model.Endereco;
import com.example.clinica_odontologica_2.repository.impl.EnderecoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepositoryImpl enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> salvarEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.salvar(endereco));
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Endereco>> buscarTodos() {
        return ResponseEntity.ok(enderecoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Integer id) {
        Endereco endereco = enderecoService.buscarPorId(id);
        if(endereco != null)
            return ResponseEntity.ok(endereco);
        return ResponseEntity.badRequest().body("Endereço não encontrado");
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
