package com.example.beomshop.product.controller;

import com.example.beomshop.product.domain.Product;
import com.example.beomshop.product.dto.CreateProductRequest;
import com.example.beomshop.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/new")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid CreateProductRequest createProductRequest) {
        Product saved = productService.save(createProductRequest);
        return ResponseEntity.ok(saved);
    }
}
