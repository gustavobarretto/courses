package com.example.clinica_odontologica_2.repository.impl;

import com.example.clinica_odontologica_2.dto.EnderecoDTO;
import com.example.clinica_odontologica_2.model.Endereco;
import com.example.clinica_odontologica_2.repository.IRepository;

import java.util.HashMap;
import java.util.Map;

public class EnderecoRepositoryImpl implements IRepository<Endereco> {
    private static Map<Integer, EnderecoDTO> enderecoDTOMap = new HashMap<>();
    private static Integer idGlobal = 1;

    @Override
    public Endereco salvar(Endereco endereco) {
        endereco.setId(idGlobal);
        EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);
        enderecoDTOMap.put(idGlobal, enderecoDTO);
        idGlobal++;
        return endereco;
    }

    @Override
    public Endereco buscarPorId(Integer id) {
        EnderecoDTO enderecoDTO = enderecoDTOMap.get(id);
        if(enderecoDTO != null)
            return new Endereco(enderecoDTO);
        return null;
    }

    @Override
    public void deletar(Integer id) {
        enderecoDTOMap.remove(id);
    }

    @Override
    public Map<Integer, Endereco> buscarTodos() {
        Map<Integer, Endereco> enderecoMap = new HashMap<>();

        for (Map.Entry<Integer, EnderecoDTO> entry : enderecoDTOMap.entrySet()) {
            Endereco endereco = new Endereco(entry.getValue());
            enderecoMap.put(endereco.getId(), endereco);
        }
        return enderecoMap;
    }

    @Override
    public Endereco atualizar(Integer id, Endereco endereco) {
        EnderecoDTO enderecoDTO = enderecoDTOMap.get(id);
        if(enderecoDTO == null)
            return null;

        endereco.setId(id);
        enderecoDTOMap.put(id, new EnderecoDTO(endereco));
        return endereco;
    }
}
