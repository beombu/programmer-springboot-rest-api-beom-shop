package com.example.beomshop.order.repository;

import com.example.beomshop.order.domain.Order;

import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);

    Optional<Order> findById(Integer orderId);
}
