package com.example.checkpointintegrador.model;

import com.example.checkpointintegrador.persistence.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Integer id;
    private String title;
    private Double price;
    private String description;
    private String image;
    private Category category;

    public Product () {}

    public Product (ProductEntity productEntity) {
        this.id = productEntity.getId();
        this.title = productEntity.getTitle();
        this.price = productEntity.getPrice();
        this.description = productEntity.getDescription();
        this.image = productEntity.getImage();
        this.category = new Category(productEntity.getCategory());
    }

}
