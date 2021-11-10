package com.example.ClinicaOdontologica.dao;

import java.util.List;

public interface IDao <T> {
    T save(T t);
    List<T> searchAll();
    T read(String email);
}
