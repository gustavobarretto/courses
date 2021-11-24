package com.example.aula28produto.persistence.service.impl;

import com.example.aula28produto.persistence.entities.ProdutoEntity;
import com.example.aula28produto.persistence.repository.ProdutoRepository;
import com.example.aula28produto.persistence.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoEntity salvar(ProdutoEntity produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<ProdutoEntity> buscartodos() {
        return produtoRepository.findAll();
    }

    @Override
    public void deletar(Integer id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public ProdutoEntity editar(ProdutoEntity produto) {

        ProdutoEntity produtoBase = produtoRepository.getById(produto.getId());

        if(produto.getNome() != null) {
            produtoBase.setNome(produto.getNome());
        }

        if(produto.getQuantidade() != null) {
            produtoBase.setQuantidade(produtoBase.getQuantidade() - produto.getQuantidade());
        }

        if(produto.getDescricao() != null) {
            produtoBase.setDescricao(produto.getDescricao());
        }


        return produtoRepository.saveAndFlush(produtoBase);
    }
}
