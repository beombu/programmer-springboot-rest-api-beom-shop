package com.example.beomshop.order.service;

import com.example.beomshop.order.domain.Order;
import com.example.beomshop.order.domain.OrderStatus;
import com.example.beomshop.order.dto.CreateOrderRequest;
import com.example.beomshop.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderServiceImpl {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(CreateOrderRequest createOrderRequest) {
        Order order = new Order(
                UUID.randomUUID(),
                OrderStatus.ACCEPTED,
                createOrderRequest.orderItems(),
                LocalDateTime.now(),
                LocalDateTime.now());

        return orderRepository.save(order);
    }
}
