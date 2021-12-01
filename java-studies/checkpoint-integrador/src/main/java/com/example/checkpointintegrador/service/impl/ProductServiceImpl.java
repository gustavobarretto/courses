package com.example.checkpointintegrador.service.impl;

import com.example.checkpointintegrador.model.Product;
import com.example.checkpointintegrador.persistence.entity.ProductEntity;
import com.example.checkpointintegrador.persistence.repository.CategoryRepository;
import com.example.checkpointintegrador.persistence.repository.ProductRepository;
import com.example.checkpointintegrador.service.CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements CommerceService<Product> {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = new ProductEntity(product);
        productEntity.setCategory(categoryRepository.saveAndFlush(productEntity.getCategory()));
        return new Product(productRepository.save(productEntity));
    }

    @Override
    public Product updateProduct(Product product, Integer id) {
        ProductEntity productEntity = productRepository.getById(id);

        if(productEntity != null) {
            if(product.getTitle() != null) {
                productEntity.setTitle(product.getTitle());
            }
            if(product.getPrice() != null) {
                productEntity.setPrice(product.getPrice());
            }
            if(product.getDescription() != null) {
                productEntity.setDescription(product.getDescription());
            }
            if(product.getImage() != null) {
                productEntity.setImage(product.getImage());
            }
        }
        return new Product(productRepository.saveAndFlush(productEntity));
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product searchById(Integer id) {
        return new Product(productRepository.findById(id).get());

    }

    @Override
    public List<Product> searchAll() {
        List<Product> productList = new ArrayList<>();

        List<ProductEntity> productEntityList = new ArrayList<>();
        productEntityList.addAll(productRepository.findAll());

        productEntityList.forEach(productEntity -> {
            Product product = new Product(productRepository.getById(productEntity.getId()));
            productList.add(product);
        });
        return productList;
    }

    @Override
    public Product searchByName(String name) {
        return null;
    }
}
