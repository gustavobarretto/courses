package com.example.Aula19.model;

import java.util.List;

public class Dentista {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String matricula;
    private Paciente paciente;

    public Dentista(Integer id, String nome, String sobrenome, String matricula, Paciente paciente) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
        this.paciente = paciente;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

}
