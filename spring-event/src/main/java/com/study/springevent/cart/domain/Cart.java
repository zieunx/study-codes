package com.study.springevent.cart.domain;

public class Cart {
    private String userId;

    public Cart(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
