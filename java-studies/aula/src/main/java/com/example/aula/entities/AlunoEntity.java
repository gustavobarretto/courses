package com.example.aula.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="alunos")
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name="idade")
    private Integer idade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="professor_id")
    private ProfessorEntity professor;
}