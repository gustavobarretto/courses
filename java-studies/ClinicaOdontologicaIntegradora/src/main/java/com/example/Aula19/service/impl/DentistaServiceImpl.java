package com.example.Aula19.service.impl;

import com.example.Aula19.model.Dentista;
import com.example.Aula19.model.Endereco;
import com.example.Aula19.model.Paciente;
import com.example.Aula19.service.DentistaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

@Service
public class DentistaServiceImpl implements DentistaService<Dentista> {

    private Endereco endereco = new Endereco("Rua Clovis", "14", "São Paulo", "SP");
    private Endereco endereco2 = new Endereco("Rua Mendes", "140", "Belo Horizonte", "MG");

    private Paciente paciente = new Paciente(1, "John", "Dutra", "johndutra@email.com", "12345678909", LocalDate.now(), endereco);
    private Paciente paciente2 = new Paciente(1, "Neide", "Blanco", "neideblanco@email.com", "98765432112", LocalDate.now(), endereco2);


    private Dentista dentista1 = new Dentista(1,"Vitor", "Galbier", "REG123", paciente);
    private Dentista dentista2 = new Dentista(2, "Eduardo", "de Araújo", "REG321", paciente2);


    @Override
    public Dentista searchAll() {
        return (Dentista) Arrays.asList(dentista1, dentista2);
    }

    @Override
    public Dentista search(Integer id) {
        if(Objects.equals(id, dentista1.getId()))
            return dentista1;
        if(Objects.equals(id, dentista2.getId()))
            return dentista2;
        return null;
    }
}
