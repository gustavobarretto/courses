package com.example.checkpointintegrador.persistence.repository;

import com.example.checkpointintegrador.model.Product;
import com.example.checkpointintegrador.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
