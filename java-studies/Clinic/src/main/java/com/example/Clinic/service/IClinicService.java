package com.example.Clinic.service;

import java.util.List;

public interface IClinicService <T> {
    T save(T t);
    T findById(Integer id);
    List<T> searchAll();
    void delete(Integer id);
    T update(T t);


}
