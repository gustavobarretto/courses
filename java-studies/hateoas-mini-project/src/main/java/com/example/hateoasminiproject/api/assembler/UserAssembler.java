package com.example.hateoasminiproject.api.assembler;

import com.example.hateoasminiproject.api.controller.UserController;
import com.example.hateoasminiproject.api.model.UserResponse;
import com.example.hateoasminiproject.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<User, UserResponse> {

    private final ModelMapper modelMapper;

    public UserAssembler(ModelMapper modelMapper) {
        super(UserController.class, UserResponse.class);
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponse toModel(User user) {
        UserResponse userResponse = createModelWithId(user.getId(), user);
        modelMapper.map(user, userResponse);
        userResponse.add(Link.of(WebMvcLinkBuilder
                .linkTo(UserController.class)
                .toUri()
                .toString(), "collection"));

        return userResponse;
    }
}
