package com.digitalbooking.backend.api.controller;

import com.digitalbooking.backend.api.assembler.ProductAssembler;
import com.digitalbooking.backend.api.assembler.ProductDisassembler;
import com.digitalbooking.backend.api.model.ProductRequest;
import com.digitalbooking.backend.api.model.ProductResponse;
import com.digitalbooking.backend.domain.filter.ProductFilter;
import com.digitalbooking.backend.domain.model.Product;
import com.digitalbooking.backend.domain.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

    private final IProductService service;
    private final ProductAssembler assembler;
    private final ProductDisassembler disassembler;
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
    public ResponseEntity<ProductResponse> get(@PathVariable String id) {
        return ResponseEntity.ok(assembler.toModel(service.findById(id)));
    }

    @GetMapping()
    public PagedModel<ProductResponse> getAll(ProductFilter filter, Pageable pageable) {
        Page<Product> pageProducts = service.findAll(filter, pageable);
        return productPagedResourcesAssembler.toModel(pageProducts, assembler);
    }


}
