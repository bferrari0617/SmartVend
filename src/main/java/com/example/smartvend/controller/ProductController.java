package com.example.smartvend.controller;

import com.example.smartvend.Product;
import com.example.smartvend.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.smartvend.ReviewDTO;
import com.example.smartvend.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.listAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<String>> getProductReviews(@PathVariable String id) {
        return productService.getProductReviewsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<?> addProductReview(@PathVariable String id, @RequestBody ReviewDTO reviewDTO) {
        return productService.addReviewToProduct(id, reviewDTO.getReview()) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}