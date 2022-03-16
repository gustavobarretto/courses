package com.digitalbooking.backend.api.assembler;

import com.digitalbooking.backend.api.controller.CityController;
import com.digitalbooking.backend.api.model.CityResponse;
import com.digitalbooking.backend.domain.model.City;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class CityAssembler extends RepresentationModelAssemblerSupport<City, CityResponse> {

    private final ModelMapper modelMapper;

    public CityAssembler(ModelMapper modelMapper) {
        super(CityController.class, CityResponse.class);
        this.modelMapper = modelMapper;
    }

    public CityResponse toModel(City city) {
        CityResponse cityResponse = createModelWithId(city.getId(), city);
        modelMapper.map(city, cityResponse);
        cityResponse.add(Link.of(WebMvcLinkBuilder
                .linkTo(CityController.class)
                .toUri()
                .toString(), "collection"));
        return cityResponse;
    }
}
