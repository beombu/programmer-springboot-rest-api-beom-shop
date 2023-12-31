package com.example.beomshop.order.domain;

import com.example.beomshop.product.domain.Category;

import java.util.UUID;

public record OrderItem(UUID productId, Category category, long price, int quantity) {
}
