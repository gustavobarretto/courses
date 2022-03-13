package com.example.hateoasminiproject.api.assembler;

import com.example.hateoasminiproject.api.model.ProductRequest;
import com.example.hateoasminiproject.domain.model.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProductDisassembler {

    private final ModelMapper modelMapper;

    public Product toDomainObject(ProductRequest productRequest) {
        return modelMapper.map(productRequest, Product.class);
    }
}
