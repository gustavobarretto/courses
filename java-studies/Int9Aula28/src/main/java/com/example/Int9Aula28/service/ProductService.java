package com.example.Int9Aula28.service;

import com.example.Int9Aula28.persistence.Entity.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);
    List<Product> searchAllProducts();
    String deleteProduct(Integer id);
    Product productSubtraction(Integer id, Integer quantity);
}
