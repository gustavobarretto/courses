package com.digitalbooking.backend.domain.service.impl;

import com.digitalbooking.backend.domain.expcetion.CategoryNotFoundException;
import com.digitalbooking.backend.domain.model.Category;
import com.digitalbooking.backend.domain.repository.ICategoryRepository;
import com.digitalbooking.backend.domain.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements ICategoryService  {

    private final ICategoryRepository repository;

    @Override
    public Category save(Category category) {
        return category.isNew() ? create(category) : update(category);
    }

    @Override
    public Category findById(String id) {
        return repository.findById(id).orElseThrow( () -> new CategoryNotFoundException(id));
    }

    @Override
    public Page<Category> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    private Category create(Category c) {
        Category category = repository.save(c);
        repository.flush();
        return category;
    }

    private Category update(Category c) {
        Category category = repository.save(c);
        repository.flush();
        return category;
    }






}
