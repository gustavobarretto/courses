package com.example.hateoasminiproject.api.controller;

import com.example.hateoasminiproject.api.model.ProductRequest;
import com.example.hateoasminiproject.domain.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.Field;
import java.util.Map;

@RestController
@RequestMapping("products")
public class ProductController {


    @PostMapping
    public ResponseEntity<?> create() {
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand("")
                .toUri())
                .build();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().build();
    }

//    @PutMapping("{id}")
//    public ResponseEntity<?> update(@PathVariable String id, @RequestBody ProductRequest productDto) {
//        return ResponseEntity.ok().build();
//    }

    @PatchMapping("{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Map<String, Object> fields) {
        Product currentProduct = null; //service.findById(id);
        merge(fields, currentProduct);

        return ResponseEntity.ok().build();
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
