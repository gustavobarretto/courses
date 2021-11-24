package com.example.aula28produto.persistence.service;

import com.example.aula28produto.persistence.entities.ProdutoEntity;
import com.example.aula28produto.persistence.repository.ProdutoRepository;

import java.util.List;

public interface ProdutoService {
    ProdutoEntity salvar(ProdutoEntity produto);
    List<ProdutoEntity> buscartodos();
    void deletar(Integer id);
    ProdutoEntity editar(ProdutoEntity produto);
}
