package com.digitalbooking.backend.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.Set;

@Getter
@Setter
public class CityResponse extends RepresentationModel<CityResponse> {

    private String id;
    private String name;
    private String country;
//    private Set<ProductResponse> products;
}
