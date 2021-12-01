package com.example.checkpointintegrador.persistence.entity;

import com.example.checkpointintegrador.model.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Set<ProductEntity> products = new HashSet<>();

    CategoryEntity () {}

    public CategoryEntity(Category category) {
        this.name = category.getName();
    }


}
