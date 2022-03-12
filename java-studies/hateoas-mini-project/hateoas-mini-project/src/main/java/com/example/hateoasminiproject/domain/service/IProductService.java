package com.example.hateoasminiproject.domain.service;

import com.example.hateoasminiproject.domain.model.Product;

import java.util.List;

public interface IProductService {

    Product save(Product product);
    Product findById(String id);
    List<Product> findAll();

}
