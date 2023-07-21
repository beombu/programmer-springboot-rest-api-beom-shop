package com.example.beomshop.order.repository;

import com.example.beomshop.order.domain.Order;

public interface OrderRepository {
    Order save(Order order);
}
