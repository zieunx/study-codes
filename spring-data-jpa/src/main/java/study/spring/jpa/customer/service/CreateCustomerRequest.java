package study.spring.jpa.customer.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateCustomerRequest {
    private String name;
    private String phone;
    private String cardNumber;
    private String subscriptionType;
}
