package com.digitalbooking.backend.domain.service.impl;

import com.digitalbooking.backend.domain.expcetion.ProductNotFoundException;
import com.digitalbooking.backend.domain.filter.ProductFilter;
import com.digitalbooking.backend.domain.model.Category;
import com.digitalbooking.backend.domain.model.Product;
import com.digitalbooking.backend.domain.repository.IProductRepository;
import com.digitalbooking.backend.domain.repository.specification.ProductSpecification;
import com.digitalbooking.backend.domain.service.IProductService;
import com.digitalbooking.backend.infrastructure.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository repository;

    @Override
    public Product save(Product product) {
        return product.isNew() ? create(product) : update(product);
    }

    @Override
    public Product findById(String id) {
        return repository.findById(id).orElseThrow( () -> new ProductNotFoundException(id));
    }

    @Override
    public Page<Product> findAll(ProductFilter filter, Pageable pageable) {
        return repository.findAll(ProductSpecification.filterProduct(filter), pageable);
    }

    private Product create(Product p) {
        Product product = repository.save(p);
        repository.flush();
        return product;
    }

    private Product update(Product p) {
        Product product = repository.save(p);
        repository.flush();
        return product;
    }
}
