package com.example.hateoasminiproject.domain.repository;

import com.example.hateoasminiproject.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {


}
