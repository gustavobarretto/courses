package com.example.clinica_odontologica_2.repository.impl;

import com.example.clinica_odontologica_2.dto.DentistaDTO;
import com.example.clinica_odontologica_2.dto.EnderecoDTO;
import com.example.clinica_odontologica_2.model.Dentista;
import com.example.clinica_odontologica_2.repository.IRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


public class DentistaRepositoryImpl implements IRepository<Dentista> {
    private static Map<Integer, DentistaDTO> dentistaDTOMap = new HashMap<>();
    private static Integer idGlobal = 1;

    @Override
    public Dentista salvar(Dentista dentista) {
        dentista.setId(idGlobal);
        DentistaDTO dentistaDTO = new DentistaDTO(dentista);
        dentistaDTOMap.put(idGlobal, dentistaDTO);
        idGlobal++;
        return dentista;
    }

    @Override
    public Dentista buscarPorId(Integer id) {
        Dentista dentista = new Dentista(dentistaDTOMap.get(id));
        return dentista;
    }

    @Override
    public void deletar(Integer id) {
        dentistaDTOMap.remove(id);
    }

    @Override
    public Map<Integer, Dentista> buscarTodos() {
        Map<Integer, Dentista> dentistaMap = new HashMap<>();

        for (Map.Entry<Integer, DentistaDTO> entry : dentistaDTOMap.entrySet()) {
            Dentista dentista = new Dentista(entry.getValue());
            dentistaMap.put(dentista.getId(), dentista);
        }
        return dentistaMap;
    }

    @Override
    public Dentista atualizar(Integer id, Dentista dentista) {
        DentistaDTO dentistaDTO = dentistaDTOMap.get(id);
        if(dentistaDTO == null)
            return null;

        dentista.setId(id);
        dentistaDTOMap.put(id, new DentistaDTO(dentista));
        return dentista;
    }
}
