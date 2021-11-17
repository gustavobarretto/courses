package com.example.clinica_odontologica_2.model;

import com.example.clinica_odontologica_2.dto.DentistaDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dentista {
    private Integer id;
    private Integer numMatricula;
    private String nome;
    private String sobrenome;

    public Dentista(DentistaDTO dentistaDTO) {
        this.id = dentistaDTO.getId();
        this.numMatricula = dentistaDTO.getNumMatricula();
        this.nome = dentistaDTO.getNome();
        this.sobrenome = dentistaDTO.getSobrenome();
    }
}
