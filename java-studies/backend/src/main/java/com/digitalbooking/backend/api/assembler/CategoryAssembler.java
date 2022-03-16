package com.digitalbooking.backend.api.assembler;

import com.digitalbooking.backend.api.controller.CategoryController;
import com.digitalbooking.backend.api.controller.ProductController;
import com.digitalbooking.backend.api.model.CategoryResponse;
import com.digitalbooking.backend.domain.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class CategoryAssembler extends RepresentationModelAssemblerSupport<Category, CategoryResponse> {

    private final ModelMapper modelMapper;

    public CategoryAssembler(ModelMapper modelMapper) {
        super(CategoryController.class, CategoryResponse.class);
        this.modelMapper = modelMapper;
    }

    public CategoryResponse toModel(Category category) {
        CategoryResponse categoryResponse = createModelWithId(category.getId(), category);
        modelMapper.map(category, categoryResponse);
        categoryResponse.add(Link.of(WebMvcLinkBuilder
                .linkTo(ProductController.class)
                .toUri()
                .toString(), "collection"));
        return categoryResponse;
    }
}
