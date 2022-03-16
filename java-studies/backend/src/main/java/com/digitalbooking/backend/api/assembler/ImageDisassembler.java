package com.digitalbooking.backend.api.assembler;

import com.digitalbooking.backend.api.model.ImageRequest;
import com.digitalbooking.backend.domain.model.Image;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ImageDisassembler {

    private final ModelMapper modelMapper;

    public Image toDomainObject(ImageRequest imageRequest) {
        return modelMapper.map(imageRequest, Image.class);
    }
}
