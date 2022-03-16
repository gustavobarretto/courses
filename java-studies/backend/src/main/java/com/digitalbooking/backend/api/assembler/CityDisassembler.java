package com.digitalbooking.backend.api.assembler;

import com.digitalbooking.backend.api.model.CityRequest;
import com.digitalbooking.backend.domain.model.City;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CityDisassembler {

    private final ModelMapper modelMapper;

    public City toDmainObject(CityRequest cityRequest) {
        return modelMapper.map(cityRequest, City.class);
    }
}
