package com.example.Int9Aula28.controller;

import com.example.Int9Aula28.persistence.Entity.Product;
import com.example.Int9Aula28.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @PostMapping("/save")
    public ResponseEntity<String> saveProduct(@RequestBody Product product) {
        ResponseEntity<String> response = null;

        if(productService.saveProduct(product) != null)
            response = ResponseEntity.ok("Product saved with sucess");
        else
            response = ResponseEntity.internalServerError().body("Error during the save execution");

        return response;
    }

    @GetMapping("/search_all")
    public ResponseEntity<List<Product>> searchAllProducts() {
        return ResponseEntity.ok(productService.searchAllProducts());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        if(productService.deleteProduct(id) != null)
            return ResponseEntity.ok("Product deleted with sucess");
        return ResponseEntity.internalServerError().body("Product not found");
    }

    @PutMapping("/subtraction_product/{id}/{quantity}")
    public ResponseEntity<String> inventorySubtractionOfAProduct(@PathVariable Integer id, @PathVariable Integer quantity) {
        Product product = productService.productSubtraction(id, quantity);
        if(product != null)
            return ResponseEntity.ok("Inventory changed with success");
        return ResponseEntity.internalServerError().body("Product not found");

    }





}
