package com.digitalbooking.backend.domain.filter;

import com.digitalbooking.backend.domain.model.Category;
import com.digitalbooking.backend.domain.model.City;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFilter {

    private String city_id;
    private String city_name;
    private String category_id;
    private String category_name;

}
