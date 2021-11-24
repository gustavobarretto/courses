package com.example.aula28produto.persistence.controller;

import com.example.aula28produto.persistence.entities.ProdutoEntity;
import com.example.aula28produto.persistence.repository.ProdutoRepository;
import com.example.aula28produto.persistence.service.impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoService;

    @PostMapping("/salvar")
    public ResponseEntity salvar(@RequestBody ProdutoEntity produto) {
        return ResponseEntity.ok(produtoService.salvar(produto));
    }

    @GetMapping
    public ResponseEntity buscarTodos(){
        return ResponseEntity.ok(produtoService.buscartodos());
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody ProdutoEntity produto){
        return ResponseEntity.ok(produtoService.editar(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Integer id) {

        produtoService.deletar(id);
        ResponseEntity<String> response = ResponseEntity.ok("Produto deletado!");

        return response;
    }
}
