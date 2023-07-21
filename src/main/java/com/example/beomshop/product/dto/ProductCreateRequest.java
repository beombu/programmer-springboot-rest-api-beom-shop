package com.example.beomshop.product.dto;

import com.example.beomshop.product.domain.Category;

public class ProductCreateRequest {
    private String productName;
    private Category category;
    private long price;
    private int stock;
    private String description;

    public ProductCreateRequest(String productName, Category category, long price, int stock, String description) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public Category getCategory() {
        return category;
    }

    public long getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getDescription() {
        return description;
    }
}
