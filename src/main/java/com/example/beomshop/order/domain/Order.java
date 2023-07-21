package com.example.beomshop.order.domain;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {
    @NotNull
    private final UUID orderId;
    @NotNull
    private OrderStatus orderStatus;
    @NotNull
    private final List<OrderItem> orderItems;
    @NotNull
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Order(UUID orderId, OrderStatus orderStatus, List<OrderItem> orderItems, LocalDateTime createdAt, LocalDateTime updatedAt) {
        validateOrderList(orderItems);
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.orderItems = orderItems;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    private void validateOrderList(List<OrderItem> productList) {
        if (productList.size() == 0) {
            throw new IllegalArgumentException("최소 한개의 주문을 담으세요");
        }
    }
}
