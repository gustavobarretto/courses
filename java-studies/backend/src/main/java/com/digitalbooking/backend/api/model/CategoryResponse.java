package com.digitalbooking.backend.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Set;

@Getter
@Setter
public class CategoryResponse extends RepresentationModel<CategoryResponse> {

    private String id;
    private String title;
    private String description;
    private String url;
//    private Set<ProductResponse> products;
}
