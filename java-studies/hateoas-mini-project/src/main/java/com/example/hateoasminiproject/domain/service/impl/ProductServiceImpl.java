package com.example.hateoasminiproject.domain.service.impl;

import com.example.hateoasminiproject.domain.exception.ProductNotFoundException;
import com.example.hateoasminiproject.domain.filter.ProductFilter;
import com.example.hateoasminiproject.domain.model.Product;
import com.example.hateoasminiproject.domain.repository.IProductRepository;
import com.example.hateoasminiproject.domain.repository.specification.ProductSpecification;
import com.example.hateoasminiproject.domain.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository IProductRepository;

    @Override
    public Product save(Product product) {
        return product.isNew() ? createProduct(product) : updateProduct(product);
    }

    @Override
    public Product findById(String id) {
        return IProductRepository.findById(id).orElseThrow( () -> new ProductNotFoundException(id));
    }

    @Override
    public Page<Product> findAll(ProductFilter filter, Pageable pageable) {
         return IProductRepository.findAll(ProductSpecification.filterProduct(filter),pageable);
    }

    private Product createProduct (Product newProduct) {
        newProduct = IProductRepository.save(newProduct);
        IProductRepository.flush();
        return newProduct;
    }

    private Product updateProduct (Product updatedProduct) {
        updatedProduct = IProductRepository.save(updatedProduct);
        IProductRepository.flush();
        return updatedProduct;
    }
}
