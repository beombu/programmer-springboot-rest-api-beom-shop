package com.example.beomshop.product.exception;

public enum ProductExceptionMessage {
    PRODUCT_ID_LOOKUP_FAILED("조회된 상품 ID가 없습니다."),
    PRODUCT_NAME_LOOKUP_FAILED("조회된 상품이 없습니다.")
    ;

    private final String message;

    ProductExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return  "[ERROR] : " + message;
    }
}
