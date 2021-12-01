package com.example.checkpointintegrador.service;

import java.util.List;

public interface CommerceService<T> {

    T saveProduct(T t);
    T updateProduct(T t, Integer id);
    void deleteProduct(Integer id);

    // Methods of search
    T searchById(Integer id);
    List<T> searchAll();

    T searchByName(String name);





}
