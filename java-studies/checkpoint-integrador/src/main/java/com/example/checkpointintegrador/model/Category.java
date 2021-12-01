package com.example.checkpointintegrador.model;

import com.example.checkpointintegrador.persistence.entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category {

    private Integer id;
    private String name;

    Category () {}

    public Category (CategoryEntity categoryEntity) {
        this.id = categoryEntity.getId();
        this.name = categoryEntity.getName();
    }

}
