package com.study.springevent.domain.order.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "order_info")
public class Order {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long orderId;

    @Column(name = "user_id")
    private String userId;

    public Order(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public Long getOrderId() {
        return orderId;
    }
}
