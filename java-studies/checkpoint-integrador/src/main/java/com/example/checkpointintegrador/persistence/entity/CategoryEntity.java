package com.example.checkpointintegrador.persistence.entity;

import com.example.checkpointintegrador.model.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "category")
public class CategoryEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "name")
    private String name;

    CategoryEntity () {}

    public CategoryEntity(Category category) {
        this.name = category.getName();
    }


}
