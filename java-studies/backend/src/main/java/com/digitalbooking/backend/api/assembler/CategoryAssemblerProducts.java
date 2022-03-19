package com.digitalbooking.backend.api.assembler;

import com.digitalbooking.backend.api.controller.CategoryController;
import com.digitalbooking.backend.api.controller.ProductController;
import com.digitalbooking.backend.api.model.CategoryResponseProducts;
import com.digitalbooking.backend.domain.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class CategoryAssemblerProducts extends RepresentationModelAssemblerSupport<Category, CategoryResponseProducts> {

    private final ModelMapper modelMapper;

    public CategoryAssemblerProducts(ModelMapper modelMapper) {
        super(CategoryController.class, CategoryResponseProducts.class);
        this.modelMapper = modelMapper;
    }

    public CategoryResponseProducts toModel(Category category) {
        CategoryResponseProducts categoryResponse = createModelWithId(category.getId(), category);
        modelMapper.map(category, categoryResponse);
        categoryResponse.add(Link.of(WebMvcLinkBuilder
                .linkTo(ProductController.class)
                .toUri()
                .toString(), "collection"));
        return categoryResponse;
    }
}
