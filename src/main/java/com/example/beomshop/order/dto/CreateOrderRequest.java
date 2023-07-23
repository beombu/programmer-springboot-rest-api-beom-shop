package com.example.beomshop.order.dto;

import com.example.beomshop.order.domain.OrderItem;

import java.util.List;

public record CreateOrderRequest(List<OrderItem> orderItems) {
}
