package com.example.aula.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="professores")
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="curso")
    private String curso;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<AlunoEntity> alunos = new HashSet<>();
}
