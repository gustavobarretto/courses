package com.example.Int9Aula28.persistence.repository;

import com.example.Int9Aula28.persistence.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

}
