package com.example.movimento.persistence.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="TABLA_MOVIMENTOS")
public class MovimentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DESC")
    private String descricao;

    @Column(name = "QUANTIA")
    private Double quantidade;





}
