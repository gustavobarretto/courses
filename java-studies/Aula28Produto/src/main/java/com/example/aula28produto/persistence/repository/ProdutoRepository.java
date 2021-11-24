package com.example.aula28produto.persistence.repository;

import com.example.aula28produto.persistence.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {

}
