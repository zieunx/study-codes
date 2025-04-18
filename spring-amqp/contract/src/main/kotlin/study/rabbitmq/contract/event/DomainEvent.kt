package study.rabbitmq.contract.event

import java.time.Instant

/**
 *  * 서비스 내 event 발행 스펙을 정의
 */
interface DomainEvent {
    val timestamp: Instant
}