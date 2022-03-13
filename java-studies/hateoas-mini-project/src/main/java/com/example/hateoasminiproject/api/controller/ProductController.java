package com.example.hateoasminiproject.api.controller;

import com.example.hateoasminiproject.api.assembler.ProductDisassembler;
import com.example.hateoasminiproject.api.assembler.ProductAssembler;
import com.example.hateoasminiproject.api.model.ProductRequest;
import com.example.hateoasminiproject.api.model.ProductResponse;
import com.example.hateoasminiproject.domain.filter.ProductFilter;
import com.example.hateoasminiproject.domain.model.Product;
import com.example.hateoasminiproject.domain.service.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

    private final IProductService service;
    private final ProductDisassembler disassembler;
    private final ProductAssembler assembler;
    private final PagedResourcesAssembler<Product> productPagedResourcesAssembler;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductRequest productRequest) {
        Product product = disassembler.toDomainObject(productRequest);
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
    public PagedModel<ProductResponse> getAll(ProductFilter filter , Pageable pageable) {
        Page<Product> pageProducts = service.findAll(filter, pageable);
        return productPagedResourcesAssembler.toModel(pageProducts,assembler);
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
