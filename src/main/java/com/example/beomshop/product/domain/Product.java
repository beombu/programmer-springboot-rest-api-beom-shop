package com.example.beomshop.product.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Product {
    private final UUID productId;
    private String productName;
    private long price;
    private int stock;
    private String description;
    private final LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Product(UUID productId, String productName, long price, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    public Product(UUID productId, String productName, long price, int stock, String description, LocalDateTime createAt, LocalDateTime updateAt) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public UUID getProductId() {
        return productId;
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }
}
