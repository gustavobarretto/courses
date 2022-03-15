package com.digitalbooking.backend.api.model;

import com.digitalbooking.backend.domain.model.Product;
import org.springframework.hateoas.RepresentationModel;

import java.util.Set;

public class CategoryResponse extends RepresentationModel<CategoryResponse> {

    private String id;
    private String title;
    private String description;
    private String url;
    private Set<Product> products;
}
