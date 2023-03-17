package study.spring.jpa.subscription.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.springframework.data.annotation.CreatedDate;
import study.spring.jpa.customer.domain.Customer;
import study.spring.jpa.customer.domain.PaymentMethod;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "subscription")
public class Subscription {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String generateType;

    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.PROXY)
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    public Subscription(String generateType, Customer customer, PaymentMethod paymentMethod) {
        this.generateType = generateType;
        this.customer = customer;
        this.paymentMethod = paymentMethod;
    }
}
