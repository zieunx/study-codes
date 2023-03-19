package study.spring.jpa.customer.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.spring.jpa.subscription.domain.Subscription;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "customer")
    private List<Subscription> subscriptions = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentMethod> paymentMethods = new ArrayList<>();

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void removePaymentMethod(long paymentMethodId) {
        PaymentMethod findPaymentMethod = paymentMethods.stream()
                .filter(paymentMethod -> paymentMethod.getId() == paymentMethodId)
                .findFirst()
                .orElseThrow(EntityNotFoundException::new);

        paymentMethods.remove(findPaymentMethod);
    }

    public void addPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethods.add(paymentMethod);
    }

    public void addSubscription(Subscription subscription) {
        this.subscriptions.add(subscription);
    }
}
