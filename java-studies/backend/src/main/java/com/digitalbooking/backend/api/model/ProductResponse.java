package com.digitalbooking.backend.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Set;

@Getter
@Setter
public class ProductResponse extends RepresentationModel<ProductResponse> {

    private String id;
    private String name;
    private String description;
    private Set<ImageResponse> images;
    private CategoryResponse category;
    private CityResponse city;
}
