package com.example.Odonto.service.impl;

import com.example.Odonto.model.Endereco;
import com.example.Odonto.model.Paciente;
import com.example.Odonto.service.OdontoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EnderecoServiceImpl implements OdontoService<Endereco> {
    private static Map<Integer, Endereco> enderecoMap = new HashMap<>();
    private static Integer idGlobal = 1;


    @Override
    public Endereco salvar(Endereco endereco) {
        endereco.setId(idGlobal);
        enderecoMap.put(idGlobal, endereco);
        idGlobal++;
        return endereco;
    }

    @Override
    public Map<Integer, Endereco> buscarTodos() {
        return enderecoMap;
    }

    @Override
    public void deletar(Integer id) {
        enderecoMap.remove(id);

    }

    @Override
    public Endereco buscarPorId(Integer id) {
        return enderecoMap.get(id);
    }

    @Override
    public Endereco atualizar(Integer id, Endereco endereco) {
       enderecoMap.put(id, endereco);
       return endereco;
    }
}
