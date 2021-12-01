package com.example.checkpointintegrador.service.impl;

import com.example.checkpointintegrador.model.Category;
import com.example.checkpointintegrador.persistence.entity.CategoryEntity;
import com.example.checkpointintegrador.persistence.repository.CategoryRepository;
import com.example.checkpointintegrador.service.CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CommerceService<Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        /*List<Category> categoryList =  new ArrayList<>();
        List<CategoryEntity> categoryEntityList = new ArrayList<>();

        categoryEntityList.addAll(categoryRepository.findAll());

        Category categorySearched = null;

        categoryEntityList.forEach(categoryEntity -> {
            if(categoryEntity.getName().equalsIgnoreCase(category.getName()))
                categorySearched = new Category(categoryRepository.getById(categoryEntity.getId()));
        });
                */
        CategoryEntity categoryEntity = new CategoryEntity(category);
        return new Category(categoryRepository.save(categoryEntity));
    }

    @Override
    public Category update(Category category, Integer id) {
        CategoryEntity categoryEntity = categoryRepository.getById(id);
        if(categoryEntity != null) {
            if(category.getName() != null) {
                categoryEntity.setName(category.getName());
            }
        }
        return new Category(categoryRepository.saveAndFlush(categoryEntity));
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category searchById(Integer id) {
        return new Category(categoryRepository.findById(id).get());
    }

    @Override
    public List<Category> searchAll() {

        return null;
    }

    @Override
    public Category searchByName(String name) {
        return null;
    }
}
