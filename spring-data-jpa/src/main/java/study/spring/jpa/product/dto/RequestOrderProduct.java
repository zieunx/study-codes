package study.spring.jpa.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RequestOrderProduct {
    private String userName;
    private String userPhoneNumber;
    private Long productId;
}
