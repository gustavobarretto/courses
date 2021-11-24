package com.example.aula28produto.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="produtos")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Integer id;
    @Column(name="nome")
    private String nome;
    @Column(name="quantidade")
    private Integer quantidade;
    @Column(name="descricao")
    private String descricao;
}
