package study.spring.jpa.subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.jpa.subscription.domain.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
