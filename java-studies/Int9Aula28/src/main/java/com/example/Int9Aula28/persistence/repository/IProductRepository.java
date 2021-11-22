package com.example.Int9Aula28.persistence.repository;

import com.example.Int9Aula28.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
