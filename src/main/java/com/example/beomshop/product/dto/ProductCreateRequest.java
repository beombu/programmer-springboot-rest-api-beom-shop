package com.example.beomshop.product.dto;

import com.example.beomshop.product.domain.Category;

public record ProductCreateRequest(String productName, Category category, long price, String description) {

}
