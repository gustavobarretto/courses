package com.example.checkpointintegrador.service.impl;

import com.example.checkpointintegrador.model.Category;
import com.example.checkpointintegrador.persistence.entity.CategoryEntity;
import com.example.checkpointintegrador.persistence.repository.CategoryRepository;
import com.example.checkpointintegrador.service.CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CommerceService<Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveProduct(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity(category);
        return new Category(categoryRepository.save(categoryEntity));
    }

    @Override
    public Category updateProduct(Category category, Integer id) {
        CategoryEntity categoryEntity = categoryRepository.getById(id);
        if(categoryEntity != null) {
            if(category.getName() != null) {
                categoryEntity.setName(category.getName());
            }
        }
        return new Category(categoryRepository.saveAndFlush(categoryEntity));
    }

    @Override
    public void deleteProduct(Integer id) {
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
