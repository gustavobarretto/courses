package com.digitalbooking.backend.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Getter
@Setter
public class CategoryResponseProducts extends RepresentationModel<CategoryResponseProducts> {

    private String id;
    private String title;
    private String description;
    private String url;
    private List<ProductResponse> products;
}
