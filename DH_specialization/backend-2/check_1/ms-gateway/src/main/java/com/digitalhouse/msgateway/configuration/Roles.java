package com.digitalhouse.msgateway.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum Roles {
    EDITOR("EDITOR"),
    USER("USER"),
    ADMIN("ADMIN");


    private String ROLE;
}
