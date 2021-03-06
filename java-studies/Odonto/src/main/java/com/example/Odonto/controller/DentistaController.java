package com.example.Odonto.controller;

import com.example.Odonto.model.Dentista;
import com.example.Odonto.model.Endereco;
import com.example.Odonto.model.Paciente;
import com.example.Odonto.service.impl.DentistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaServiceImpl dentistaService;

    @PostMapping
    public ResponseEntity<Dentista> salvarDentista(@RequestBody Dentista dentista) {
        return ResponseEntity.ok(dentistaService.salvar(dentista));
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Dentista>> buscarTodos() {
        return ResponseEntity.ok(dentistaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentista> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(dentistaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id) {
        dentistaService.deletar(id);
        return "Dentista deletado!";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dentista> atualizar(@PathVariable Integer id, @RequestBody Dentista dentista) {
        return ResponseEntity.ok(dentistaService.atualizar(id, dentista));
    }
}
