package com.example.hateoasminiproject.api.assembler;

import com.example.hateoasminiproject.api.controller.ProductController;
import com.example.hateoasminiproject.api.model.ProductResponse;
import com.example.hateoasminiproject.domain.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProductAssembler extends RepresentationModelAssemblerSupport<Product,ProductResponse> {

    public ProductAssembler( ModelMapper modelMapper) {
        super(ProductController.class, ProductResponse.class);
        this.modelMapper = modelMapper;
    }

    private final ModelMapper modelMapper;

    public ProductResponse toModel(Product product){

        ProductResponse productResponse = createModelWithId(product.getId(),product);
                modelMapper.map(product,productResponse);
        productResponse.add(Link.of(WebMvcLinkBuilder
                .linkTo(ProductController.class)
                .toUri()
                .toString(),"collection"));

        return productResponse;
    }

}
