package com.digitalbooking.backend.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {

    private String title;
    private String description;
    private String url;

}
