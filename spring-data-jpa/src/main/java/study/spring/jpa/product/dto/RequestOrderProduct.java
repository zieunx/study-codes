package study.spring.jpa.product.dto;

import lombok.Getter;

@Getter
public class RequestOrderProduct {
    private String userName;
    private String userPhoneNumber;
    private Long productId;
}
