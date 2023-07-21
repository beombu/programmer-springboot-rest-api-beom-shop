package com.example.beomshop.order.controller;

import com.example.beomshop.order.domain.Order;
import com.example.beomshop.order.dto.CreateOrderRequest;
import com.example.beomshop.order.service.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrderRestController {
    private final OrderServiceImpl orderService;

    public OrderRestController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/new")
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        Order order = orderService.createOrder(createOrderRequest);

        return ResponseEntity.ok(order);
    }
}
