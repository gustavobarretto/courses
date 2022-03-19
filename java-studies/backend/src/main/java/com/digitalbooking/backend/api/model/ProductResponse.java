package com.digitalbooking.backend.api.model;

import com.digitalbooking.backend.domain.model.Characteristic;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Getter
@Setter
public class ProductResponse extends RepresentationModel<ProductResponse> {

    private String id;
    private String name;
    private String description;
    private List<ImageResponse> images;
    private List<Characteristic> characteristics;
    private CategoryResponse category;
    private CityResponse city;
    private Integer stars;
    private Double rating;

}
