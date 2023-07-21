package com.example.beomshop.product.service;

import com.example.beomshop.product.Repository.ProductRepository;
import com.example.beomshop.product.domain.Product;
import com.example.beomshop.product.dto.ProductCreateRequest;
import com.example.beomshop.product.exception.ProductIdNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.example.beomshop.product.exception.ProductExceptionMessage.PRODUCT_ID_LOOKUP_FAILED;

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
                productCreateRequest.getProductName(),
                productCreateRequest.getCategory(),
                productCreateRequest.getPrice(),
                productCreateRequest.getStock(),
                productCreateRequest.getDescription()
        );
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(UUID productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductIdNotFoundException(PRODUCT_ID_LOOKUP_FAILED));
    }

//    public List<Product> findByCategory(Category category) {
//        return productRepository.findByCategory(category);
//    }
}
