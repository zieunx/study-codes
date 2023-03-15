package study.spring.jpa.customer.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.spring.jpa.subscription.domain.Subscription;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "customer")
public class Customer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String phone;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    private List<Subscription> subscriptions;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private List<PaymentMethod> paymentMethods;

    public Customer(String name, String phone, List<Subscription> subscriptions, List<PaymentMethod> paymentMethods) {
        this.name = name;
        this.phone = phone;
        this.subscriptions = subscriptions;
        this.paymentMethods = paymentMethods;
    }

    public void removePaymentMethod(long paymentMethodId) {
        PaymentMethod findPaymentMethod = paymentMethods.stream()
                .filter(paymentMethod -> paymentMethod.getId() == paymentMethodId)
                .findFirst()
                .orElseThrow(EntityNotFoundException::new);

        paymentMethods.remove(findPaymentMethod);
    }
}
