package com.example.Int9Aula28.service.impl;

import com.example.Int9Aula28.persistence.entities.Product;
import com.example.Int9Aula28.persistence.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {

    @Autowired
    IProductRepository productRepository;


}
