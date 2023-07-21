package com.example.beomshop.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(ProductIdNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductIdNotFoundException(ProductIdNotFoundException productIdNotFoundException) {
        ErrorResponse errorResponse = new ErrorResponse(productIdNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(ProductNameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNameNotFoundException(ProductNameNotFoundException productNameNotFoundException) {
        ErrorResponse errorResponse = new ErrorResponse(productNameNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
