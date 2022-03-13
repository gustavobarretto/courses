package com.example.hateoasminiproject.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String password;

}
