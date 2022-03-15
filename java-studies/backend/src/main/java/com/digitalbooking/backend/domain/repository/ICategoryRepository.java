package com.digitalbooking.backend.domain.repository;

import com.digitalbooking.backend.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, String> {

    Category findByTitle(String title);
}
