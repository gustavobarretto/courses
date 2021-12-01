package com.example.checkpointintegrador.persistence.entity;

import com.example.checkpointintegrador.model.Category;
import com.example.checkpointintegrador.model.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "products")
public class ProductEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public ProductEntity() {}

    public ProductEntity(Product product) {
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.image = product.getImage();
        this.category = new CategoryEntity(product.getCategory());

    }



}
