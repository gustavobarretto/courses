package com.example.hateoasminiproject.domain.service.impl;

import com.example.hateoasminiproject.domain.exception.ProductNotFoundException;
import com.example.hateoasminiproject.domain.filter.ProductFilter;
import com.example.hateoasminiproject.domain.model.Product;
import com.example.hateoasminiproject.domain.repository.ProductRepository;
import com.example.hateoasminiproject.domain.repository.ProductSpecification;
import com.example.hateoasminiproject.domain.service.IProductService;
import com.example.hateoasminiproject.infrastructure.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        return productRepository.findById(id).orElseThrow( () -> new ProductNotFoundException(id));
    }

    @Override
    public Page<Product> findAll(ProductFilter filter, Pageable pageable) {
         return productRepository.findAll(ProductSpecification.filterProduct(filter),pageable);
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
