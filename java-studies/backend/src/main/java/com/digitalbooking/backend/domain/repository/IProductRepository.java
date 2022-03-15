package com.digitalbooking.backend.domain.repository;

import com.digitalbooking.backend.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IProductRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {
}
