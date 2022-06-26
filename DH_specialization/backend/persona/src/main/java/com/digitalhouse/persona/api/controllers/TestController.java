package com.digitalhouse.persona.api.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/message")
public class TestController {

    @Value("${message}")
    private String message;


    @GetMapping
    ResponseEntity<String> gerMessage() {
        return ResponseEntity.ok().body(this.message);
    }


}
