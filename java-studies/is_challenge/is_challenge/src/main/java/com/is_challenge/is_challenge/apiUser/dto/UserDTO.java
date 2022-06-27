package com.is_challenge.is_challenge.apiUser.dto;

import com.is_challenge.is_challenge.apiUser.entity.Roles;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String name;
    private String email;
    private String password;

}
