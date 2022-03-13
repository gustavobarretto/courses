package com.example.hateoasminiproject.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class UserResponse extends RepresentationModel<UserResponse> {

    private String id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
}
