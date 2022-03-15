package com.digitalbooking.backend.domain.service;

import com.digitalbooking.backend.domain.filter.ProductFilter;
import com.digitalbooking.backend.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductService {

    Product save(Product product);
    Product findById(String id);
    Page<Product> findAll(ProductFilter filter, Pageable pageable);

}
