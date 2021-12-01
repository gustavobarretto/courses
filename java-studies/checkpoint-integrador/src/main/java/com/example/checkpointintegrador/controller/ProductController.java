package com.example.checkpointintegrador.controller;

import com.example.checkpointintegrador.model.Product;
import com.example.checkpointintegrador.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/save")
    private ResponseEntity saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping("/{id}")
    private ResponseEntity searchProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.searchById(id));
    }

    @GetMapping("/all")
    private ResponseEntity searchAll() {
        return ResponseEntity.ok(productService.searchAll());
    }

    @GetMapping("/categories/all/{name}")
    private ResponseEntity searchByCategory(@PathVariable String name) {
        return ResponseEntity.ok(productService.searchByCategory(name));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteProduct(@PathVariable Integer id) {
        productService.delete(id);
        return ResponseEntity.ok("Product deleted");
    }

    @PutMapping("/update/{id}")
    private ResponseEntity updateProduct(@RequestBody Product product, @PathVariable Integer id) {
        return ResponseEntity.ok(productService.update(product, id));
    }

}
