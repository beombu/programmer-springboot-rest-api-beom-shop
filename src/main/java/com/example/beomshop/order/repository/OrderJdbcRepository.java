package com.example.beomshop.order.repository;

import com.example.beomshop.order.domain.Order;
import com.example.beomshop.order.domain.OrderItem;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class OrderJdbcRepository implements OrderRepository{
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OrderJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Map<String, Object> toOrderParamMap(Order order) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("order_id", order.getOrderId().toString());
        paramMap.put("order_status", order.getOrderStatus().toString());
        paramMap.put("created_at", order.getCreatedAt());
        paramMap.put("updated_at", order.getUpdatedAt());
        return paramMap;
    }

    private Map<String, Object> toOrderItemParamMap(UUID orderId, OrderItem item) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("order_id", orderId.toString());
        paramMap.put("product_id", item.productId().toString());
        paramMap.put("category", item.category().toString());
        paramMap.put("price", item.price());
        paramMap.put("quantity", item.quantity());
        return paramMap;
    }

    @Override
    public Order save(Order order) {
        jdbcTemplate.update("INSERT INTO orders (order_id, order_status, created_at, updated_at) " +
                        "VALUES (:order_id, :order_status, :created_at, :updated_at)",
                toOrderParamMap(order));
        order.getOrderItems()
                .forEach(item ->
                        jdbcTemplate.update("INSERT INTO order_items(order_id, product_id, category, price, quantity) " +
                                        "VALUES (:order_id, :product_id, :category, :price, :quantity)",
                                toOrderItemParamMap(order.getOrderId(), item)));
        return order;
    }
}
