package com.example.hateoasminiproject.domain.service.impl;

import com.example.hateoasminiproject.domain.model.Product;
import com.example.hateoasminiproject.domain.repository.ProductRepository;
import com.example.hateoasminiproject.domain.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return product.isNew() ? createProduct(product) : updateProduct(product);
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    private Product createProduct (Product newProduct) {
        newProduct = productRepository.save(newProduct);
        productRepository.flush();
        return newProduct;
    }

    private Product updateProduct (Product updatedProduct) {
        updatedProduct = productRepository.save(updatedProduct);
        productRepository.flush();
        return updatedProduct;
    }
}
