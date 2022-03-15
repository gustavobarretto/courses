package com.digitalbooking.backend.api.model;

import com.digitalbooking.backend.domain.model.Product;
import org.springframework.hateoas.RepresentationModel;

import java.util.Set;

public class CityResponse extends RepresentationModel<CityResponse> {

    private String id;
    private String name;
    private String country;
    private Set<Product> products;
}
