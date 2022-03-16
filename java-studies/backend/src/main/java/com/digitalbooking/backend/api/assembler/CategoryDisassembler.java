package com.digitalbooking.backend.api.assembler;

import com.digitalbooking.backend.api.model.CategoryRequest;
import com.digitalbooking.backend.domain.model.Category;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CategoryDisassembler {

    private final ModelMapper modelMapper;

    public Category toDomainObject(CategoryRequest categoryRequest) {
        return modelMapper.map(categoryRequest, Category.class);
    }
}
