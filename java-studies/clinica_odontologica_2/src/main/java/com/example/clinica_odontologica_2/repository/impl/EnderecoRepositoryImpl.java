package com.example.clinica_odontologica_2.repository.impl;

import com.example.clinica_odontologica_2.dto.EnderecoDTO;
import com.example.clinica_odontologica_2.model.Endereco;
import com.example.clinica_odontologica_2.repository.IRepository;

import java.util.HashMap;
import java.util.Map;

public class EnderecoRepositoryImpl implements IRepository<Endereco> {
    private static Map<Integer, EnderecoDTO> enderecoMap = new HashMap<>();
    private static Integer idGlobal = 1;

    @Override
    public Endereco salvar(Endereco endereco) {
        endereco.setId(idGlobal);
        EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);
        enderecoMap.put(idGlobal, enderecoDTO);
        idGlobal++;
        return endereco;
    }

    @Override
    public Endereco buscarPorId(Integer id) {
        Endereco endereco = new Endereco(enderecoMap.get(id));
        return endereco;
    }
}
