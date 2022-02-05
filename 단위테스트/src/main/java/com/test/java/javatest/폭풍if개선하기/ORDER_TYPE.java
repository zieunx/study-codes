package com.test.java.javatest.폭풍if개선하기;

import java.util.Arrays;

public enum ORDER_TYPE {
    WEB_DELIVERY("WD", "DELIVERY", "웹 배달주문"),
    WEB_PICKUP("WC", "PICKUP", "웹 방문포장"),
    MOBILE_DELIVERY("MD", "DELIVERY", "모바일 배달주문"),
    MOBILE_PICKUP("MC", "PICKUP", "모바일 방문포장"),
    EMPTY(null, null, "없음");

    private final String code;
    private final String type;
    private final String title;

    ORDER_TYPE(String code, String type, String title) {
        this.code = code;
        this.title = title;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public static ORDER_TYPE findByCode(String code) {
        return Arrays.stream(ORDER_TYPE.values())
                .filter(type -> code.equals(type.code))
                .findFirst()
                .orElse(EMPTY);
    }

    public static ORDER_TYPE findByName(String name) {
        return Arrays.stream(ORDER_TYPE.values())
                .filter(type -> type.name().equals(name))
                .findFirst()
                .orElse(EMPTY);
    }

    public String getTitle() {
        return title;
    }

    public boolean isDelivery() {
        return this.name().contains("DELIVERY");
    }

    public boolean isPickUp() {
        return this.name().contains("PICKUP");
    }

    public boolean isEmpty() {
        return this.code == null;
    }
}
