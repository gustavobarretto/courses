package com.digitalbooking.backend.api.model;

import com.digitalbooking.backend.domain.model.Category;
import com.digitalbooking.backend.domain.model.City;
import com.digitalbooking.backend.domain.model.Image;

import java.util.Set;

public class ProductRequest {

    private String name;
    private String description;
    private Set<Image> images;
    private Category category;
    private City city;
}
