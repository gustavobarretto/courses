package com.example.hateoasminiproject.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class ProductResponse extends RepresentationModel<ProductResponse> {

    private String id;
    private String title;
    private String description;
    private Double price;
    private String classification;

}
