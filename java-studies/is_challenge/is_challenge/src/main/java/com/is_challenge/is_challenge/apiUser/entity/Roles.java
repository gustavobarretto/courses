package com.is_challenge.is_challenge.apiUser.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Roles {
    READER(0, "ROLE_READER"),
    BASIC(1, "ROLE_BASIC"),
    ADVANCED(2, "ROLE_ADVANCED"),
    ADMIN(3, "ROLE_ADMIN");

    private final int cod;
    private final String name;
}
