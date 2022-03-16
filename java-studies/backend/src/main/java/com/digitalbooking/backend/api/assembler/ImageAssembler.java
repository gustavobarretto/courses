package com.digitalbooking.backend.api.assembler;

import com.digitalbooking.backend.api.controller.ImageController;
import com.digitalbooking.backend.api.model.ImageResponse;
import com.digitalbooking.backend.domain.model.Image;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class ImageAssembler extends RepresentationModelAssemblerSupport<Image, ImageResponse> {

    private final ModelMapper modelMapper;

    public ImageAssembler(ModelMapper modelMapper) {
        super(ImageController.class, ImageResponse.class);
        this.modelMapper = modelMapper;
    }

    public ImageResponse toModel(Image image) {
        ImageResponse imageResponse = createModelWithId(image.getId(), image);
        modelMapper.map(image, imageResponse);
        imageResponse.add(Link.of(WebMvcLinkBuilder
                .linkTo(ImageController.class)
                .toUri()
                .toString(), "collection"));
        return imageResponse;
    }
}
