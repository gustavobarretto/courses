package com.digitalbooking.backend.api.assembler;

import com.digitalbooking.backend.api.controller.ProductController;
import com.digitalbooking.backend.api.model.ProductResponse;
import com.digitalbooking.backend.domain.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProductAssembler extends RepresentationModelAssemblerSupport<Product, ProductResponse> {

    private final ModelMapper modelMapper;

    public ProductAssembler(ModelMapper modelMapper) {
        super(ProductController.class, ProductResponse.class);
        this.modelMapper = modelMapper;
    }

    public ProductResponse toModel(Product product) {
        ProductResponse productResponse = createModelWithId(product.getId(), product);
        modelMapper.map(product, productResponse);
        productResponse.add(Link.of(WebMvcLinkBuilder
                .linkTo(ProductController.class)
                .toUri()
                .toString(), "collection"));
        return productResponse;
    }
}
