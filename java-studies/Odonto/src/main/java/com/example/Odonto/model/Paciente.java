package com.example.Odonto.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paciente {
    private String nome;
    private String sobrenome;
    private String email;
    private Integer idade;

    public Paciente(String nome, String sobrenome, String email, Integer idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.idade = idade;
    }


}
