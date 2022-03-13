package com.example.hateoasminiproject.api.assembler;

import com.example.hateoasminiproject.api.model.UserRequest;
import com.example.hateoasminiproject.domain.model.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDisassembler {

    private final ModelMapper modelMapper;

    public User toDomainObject(UserRequest userRequest) {
        return modelMapper.map(userRequest, User.class);
    }
}
