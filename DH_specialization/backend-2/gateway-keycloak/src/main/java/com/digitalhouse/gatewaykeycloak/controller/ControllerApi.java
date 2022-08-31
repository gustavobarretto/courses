package com.digitalhouse.gatewaykeycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ControllerApi {

    @GetMapping
    public String getName(Principal principal) {
        return principal.getName();
    }
}
