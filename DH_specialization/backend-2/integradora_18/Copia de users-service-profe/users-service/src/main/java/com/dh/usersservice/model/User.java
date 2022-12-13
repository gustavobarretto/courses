package com.dh.usersservice.model;

public record User(
        String userId,
        String firstName,
        String lastName,
        String email,
        String color,
        String age
) {}
