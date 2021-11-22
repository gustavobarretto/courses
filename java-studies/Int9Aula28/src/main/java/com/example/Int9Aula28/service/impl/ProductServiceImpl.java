package com.example.Int9Aula28.service.impl;

import com.example.Int9Aula28.persistence.Entity.Product;

import com.example.Int9Aula28.persistence.repository.IProductRepository;
import com.example.Int9Aula28.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> searchAllProducts() {
        return productRepository.findAll();

    }

    @Override
    public String deleteProduct(Integer id) {
        Product product = productRepository.findById(id).get();

        if(product != null) {
            productRepository.deleteById(id);
            return "OK";
        }
        return null;
    }

    @Override
    public Product productSubtraction(Integer id, Integer quantity) {
        Product product = productRepository.findById(id).get();
        Integer operation = product.getInventory() - quantity;
        if(operation < 0)
            return null;
        product.setInventory(product.getInventory() - quantity);
        return productRepository.saveAndFlush(product);
    }

}
