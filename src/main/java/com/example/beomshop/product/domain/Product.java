package com.example.beomshop.product.domain;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public class Product {
    @NotNull
    private final UUID productId;
    @NotNull
    private String productName;
    @NotNull
    private Category category;
    @NotNull
    private long price;
    @NotNull
    private int stock;
    private String description;
    @NotNull
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(String productName, Category category, long price, int stock, String description) {
        this.productId = UUID.randomUUID();
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Product(UUID productId, String productName, Category category, long price, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Product(UUID productId, String productName, Category category, long price, int stock, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getProductId() {
        return productId;
    }

    public Category getCategory() {
        return category;
    }

    public String getProductName() {
        return productName;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
