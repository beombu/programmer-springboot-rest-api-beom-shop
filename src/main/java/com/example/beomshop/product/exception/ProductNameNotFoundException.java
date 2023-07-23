package com.example.beomshop.product.exception;

public class ProductNameNotFoundException extends RuntimeException {
    public ProductNameNotFoundException(ProductExceptionMessage message) {
        super(message.getMessage());
    }
}
