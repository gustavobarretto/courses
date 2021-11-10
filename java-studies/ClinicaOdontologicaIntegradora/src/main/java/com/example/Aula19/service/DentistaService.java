package com.example.Aula19.service;

import java.util.Optional;

public interface DentistaService<Dentista> {
    Dentista searchAll();
    Dentista search(Integer id);

}
