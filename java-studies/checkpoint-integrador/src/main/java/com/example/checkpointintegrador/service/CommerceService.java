package com.example.checkpointintegrador.service;

import java.util.List;

public interface CommerceService<T> {

    T save(T t);
    T update(T t, Integer id);
    void delete(Integer id);

    // Methods of search
    T searchById(Integer id);
    List<T> searchAll();

    T searchByName(String name);





}
