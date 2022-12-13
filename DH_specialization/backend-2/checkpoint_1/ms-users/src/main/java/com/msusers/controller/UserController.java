package com.msusers.controller;

import com.msusers.feign.feignmodel.BillDto;
import com.msusers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<?> createBills(@RequestBody List<BillDto> dtos) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.createBills(dtos));
    }

    @GetMapping("/bills/{id}")
    public ResponseEntity<?> getBills(@PathVariable String idUser) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.getBills(idUser));
    }
}
