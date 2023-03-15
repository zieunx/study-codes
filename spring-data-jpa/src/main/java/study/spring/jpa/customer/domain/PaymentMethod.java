package study.spring.jpa.customer.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "payment_method")
public class PaymentMethod {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String cardNumber;

    public PaymentMethod(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
