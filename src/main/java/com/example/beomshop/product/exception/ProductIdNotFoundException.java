package com.example.beomshop.product.exception;

public class ProductIdNotFoundException extends RuntimeException {
    public ProductIdNotFoundException(ProductExceptionMessage message) {
        super(message.getMessage());
    }
}
