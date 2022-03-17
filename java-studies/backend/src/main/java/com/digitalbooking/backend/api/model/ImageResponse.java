package com.digitalbooking.backend.api.model;

import com.digitalbooking.backend.domain.model.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class ImageResponse extends RepresentationModel<ImageResponse> {

    private String id;
    private String title;
    private String url;
//    private ProductResponse product;

}
