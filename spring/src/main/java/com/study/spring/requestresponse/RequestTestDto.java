package com.study.spring.requestresponse;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RequestTestDto {
    private String code;
    private int price;

    @Override
    public String toString() {
        return "RequestTestDto{" +
                "code='" + code + '\'' +
                ", price=" + price +
                '}';
    }
}
