package com.example.beomshop.product.service;

import com.example.beomshop.product.Repository.ProductRepository;
import com.example.beomshop.product.domain.Category;
import com.example.beomshop.product.domain.Product;
import com.example.beomshop.product.dto.ProductCreateRequest;
import com.example.beomshop.product.exception.ProductIdNotFoundException;
import com.example.beomshop.product.exception.ProductNameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.example.beomshop.product.exception.ProductExceptionMessage.PRODUCT_ID_LOOKUP_FAILED;
import static com.example.beomshop.product.exception.ProductExceptionMessage.PRODUCT_NAME_LOOKUP_FAILED;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(ProductCreateRequest productCreateRequest) {
        Product product = createProduct(productCreateRequest);

        return productRepository.insert(product);
    }

    private Product createProduct(ProductCreateRequest productCreateRequest) {
        return new Product(
                productCreateRequest.productName(),
                productCreateRequest.category(),
                productCreateRequest.price(),
                productCreateRequest.description()
        );
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(UUID productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductIdNotFoundException(PRODUCT_ID_LOOKUP_FAILED));
    }

    public Product findByName(String productName) {
        return productRepository.findByName(productName)
                .orElseThrow(() -> new ProductNameNotFoundException(PRODUCT_NAME_LOOKUP_FAILED));
    }

    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    public void deleteById(UUID productId) {
        productRepository.deleteById(productId);
    }
}
