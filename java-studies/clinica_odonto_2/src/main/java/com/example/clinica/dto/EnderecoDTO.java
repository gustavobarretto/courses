package com.example.clinica.dto;

import com.example.clinica.model.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {
    private Integer id;
    private String rua;
    private String numero;

    public EnderecoDTO(Endereco endereco) {
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
    }
}

