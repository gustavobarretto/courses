package com.digitalbooking.backend.api.assembler;

import com.digitalbooking.backend.api.model.ProductRequest;
import com.digitalbooking.backend.domain.model.Product;
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
