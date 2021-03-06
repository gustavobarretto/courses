package com.digitalbooking.backend.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class CategoryResponse extends RepresentationModel<CategoryResponse> {

    private String id;
    private String title;
    private String description;
    private String url;
}
