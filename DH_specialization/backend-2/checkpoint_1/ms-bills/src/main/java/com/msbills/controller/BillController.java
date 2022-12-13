package com.msbills.controller;

import com.msbills.models.Bill;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Bill b) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(b));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_PROVIDER')")
    public ResponseEntity<List<Bill>> getAll() {
        return ResponseEntity.ok().body(service.getAllBill());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_PROVIDER')")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/all/{idUser}")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_PROVIDER')")
    public ResponseEntity<?> getAllByIdUser(@PathVariable String idUser) {
        return ResponseEntity.ok(service.getAllByUserId(idUser));
    }

}
