package com.example.Int9Aula28.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter

@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (name = "ID")
    private Integer id;

    @Column (name = "PRODUCT_NAME")
    private String name;

    @Column (name = "PRODUCT_INVENTORY")
    private Integer inventory;

    @Column (name = "PRODUCT_DESCRIPTION")
    private String description;


}
