package com.digitalbooking.backend.api.model;

import com.digitalbooking.backend.domain.model.Product;
import org.springframework.hateoas.RepresentationModel;

public class ImageResponse extends RepresentationModel<ImageResponse> {

    private String id;
    private String title;
    private String url;
    private Product product;

}
