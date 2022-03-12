package com.example.hateoasminiproject.api.controller;

import com.example.hateoasminiproject.api.assembler.ProductAssembler;
import com.example.hateoasminiproject.api.model.ProductRequest;
import com.example.hateoasminiproject.domain.model.Product;
import com.example.hateoasminiproject.domain.service.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.Field;
import java.util.Map;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

    private final IProductService service;
    private final ProductAssembler assembler;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductRequest productRequest) {
        Product product = assembler.toDomainObject(productRequest);
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(service.save(product).getId())
                .toUri())
                .build();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Map<String, Object> fields) {
        Product currentProduct = service.findById(id);
        merge(fields, currentProduct);
        service.save(currentProduct);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    private void merge(Map<String, Object> fields, Product currentProduct) {
        ObjectMapper mapper = new ObjectMapper();
        Product productOrigin = mapper.convertValue(fields, Product.class);

        fields.forEach((propertyName, propertyValue) -> {
            Field field = ReflectionUtils.findField(Product.class, propertyName);
            assert field != null;
            field.setAccessible(true);
            Object newValue = ReflectionUtils.getField(field, productOrigin);
            ReflectionUtils.setField(field, currentProduct, newValue);
        });
    }
}
