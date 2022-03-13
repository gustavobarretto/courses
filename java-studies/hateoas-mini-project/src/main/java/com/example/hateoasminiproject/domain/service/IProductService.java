package com.example.hateoasminiproject.domain.service;

import com.example.hateoasminiproject.domain.filter.ProductFilter;
import com.example.hateoasminiproject.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    Product save(Product product);
    Product findById(String id);
    Page<Product> findAll(ProductFilter filter, Pageable pageable);

}
