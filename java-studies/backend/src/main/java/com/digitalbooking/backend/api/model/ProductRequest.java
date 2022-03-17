package com.digitalbooking.backend.api.model;

import com.digitalbooking.backend.domain.model.Category;
import com.digitalbooking.backend.domain.model.City;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductRequest {

    private String name;
    private String description;
    private Set<ImageRequest> images;
    private CategoryRequest category;
    private CityRequest city;
}
