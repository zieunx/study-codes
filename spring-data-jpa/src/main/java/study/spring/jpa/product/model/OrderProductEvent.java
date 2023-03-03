package study.spring.jpa.product.model;

import study.spring.jpa.product.dto.RequestOrderProduct;

public class OrderProductEvent {
    private String userName;
    private String userPhoneNumber;
    private Long productId;


    public OrderProductEvent(RequestOrderProduct request) {
        userName = request.getUserName();
        userPhoneNumber = request.getUserPhoneNumber();
        productId = request.getProductId();
    }
}
