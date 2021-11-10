package com.example.ClinicaOdontologica.service;

import java.util.List;

public interface PatientService<T> {
    T save(T t);
    List<T> searchAll();
    T search(String email);
}
