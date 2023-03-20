package study.spring.jpa.customer.domain;



import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.spring.jpa.subscription.domain.Subscription;

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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "paymentMethod")
    private Subscription subscription;

    public PaymentMethod(String cardNumber, Customer customer) {
        this.cardNumber = cardNumber;
        this.customer = customer;
    }
}
