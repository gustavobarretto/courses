package com.digitalbooking.backend.domain.service;


import com.digitalbooking.backend.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {

    Category save(Category category);
    Category findById(String id);
    Page<Category> findAll(Pageable page);
    void delete(String id);

}
