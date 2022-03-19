package com.digitalbooking.backend.api.model;

import com.digitalbooking.backend.domain.model.Category;
import com.digitalbooking.backend.domain.model.Characteristic;
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
    private Set<Characteristic> characteristics;
    private CategoryRequest category;
    private CityRequest city;
    private Integer stars;
    private Double rating;
}
