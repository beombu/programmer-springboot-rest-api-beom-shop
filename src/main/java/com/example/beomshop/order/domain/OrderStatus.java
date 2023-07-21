package com.example.beomshop.order.domain;

import java.util.Arrays;
import java.util.Objects;

public enum OrderStatus {
    ACCEPTED("결제완료"),
    READY_FOR_DELIVERY("배송준비중"),
    DELIVERING("배송중"),
    DELIVERED("배송완료"),
    CANCELED("취소됨");

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
