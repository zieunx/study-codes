package study.rabbitmq.contract.event

import java.time.Instant

/**
 * Message 로 발행하는 Event 모두가 상속해야되는 Class
 * 기본값이 세팅되어있다.
 */
open class BaseDomainEvent(
    override val timestamp: Instant = Instant.now()
): DomainEvent