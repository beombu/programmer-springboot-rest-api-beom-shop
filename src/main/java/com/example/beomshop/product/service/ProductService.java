package com.example.beomshop.product.service;

import com.example.beomshop.product.Repository.ProductRepository;
import com.example.beomshop.product.domain.Product;
import com.example.beomshop.product.dto.CreateProductRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(CreateProductRequest createProductRequest) {
        Product product = createProduct(createProductRequest);

        return productRepository.insert(product);
    }

    private Product createProduct(CreateProductRequest createProductRequest) {
        return new Product(
                createProductRequest.getProductName(),
                createProductRequest.getCategory(),
                createProductRequest.getPrice(),
                createProductRequest.getStock(),
                createProductRequest.getDescription()
        );
    }
}
