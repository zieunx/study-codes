package study.kotlin.event_sample

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EventService(
    private val applicationEventPublisher: ApplicationEventPublisher,
) {

    @Transactional
    fun success(event: OrderCommitEvent) {
        println("===> success 실행")
        println("...실행중 ....")

        applicationEventPublisher.publishEvent(event)

        println("===> success 종료")
    }

    @Transactional
    fun exception(event: OrderCommitEvent) {
        println("===> exception 실행")
        println("...실행중 ....")

        applicationEventPublisher.publishEvent(event)

        throw IllegalArgumentException("예외 발생!!!")
    }

    @Transactional(noRollbackFor = [IllegalArgumentException::class])
    fun noRollbackTransaction(event: OrderCommitEvent) {
        println("===> noRollbackTransaction 실행")
        println("...실행중 ....")

        applicationEventPublisher.publishEvent(event)

        throw IllegalArgumentException("예외 발생!!!")
    }
}
