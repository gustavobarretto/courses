package com.example.clinica.repository.impl;

import com.example.clinica.dto.EnderecoDTO;
import com.example.clinica.model.Endereco;
import com.example.clinica.repository.IRepository;

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
        enderecoMap.containsValue(enderecoDTO);
        return endereco;
    }

    @Override
    public Endereco buscarPorId(Integer id) {
        Endereco endereco = new Endereco(enderecoMap.get(id));
        return endereco;
    }
}
