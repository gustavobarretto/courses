package com.example.hateoasminiproject.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    private String id;
    private String title;
    private String description;
    private Double price;
    private String classification;

}
