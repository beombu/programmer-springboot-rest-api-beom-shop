package com.example.beomshop.product.controller;

import com.example.beomshop.product.domain.Category;
import com.example.beomshop.product.domain.Product;
import com.example.beomshop.product.dto.ProductCreateRequest;
import com.example.beomshop.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/shop")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/new")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductCreateRequest productCreateRequest) {
        Product saved = productService.save(productCreateRequest);

        return ResponseEntity.ok(saved);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAllProduct() {
        List<Product> products = productService.findAll();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> findById(@PathVariable UUID productId) {
        Product product = productService.findById(productId);

        return ResponseEntity.ok(product);
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity<Product> findById(@PathVariable String productName) {
        Product product = productService.findByName(productName);

        return ResponseEntity.ok(product);
    }

    @GetMapping("/product/category")
    public ResponseEntity<List<Product>> productList(@RequestParam Optional<Category> category) {
        List<Product> products = category
                .map(productService::findByCategory)
                .orElse(productService.findAll());

        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity deleteById(@PathVariable UUID productId) {
        productService.deleteById(productId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
