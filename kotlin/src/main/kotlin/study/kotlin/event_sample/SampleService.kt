package study.kotlin.event_sample

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SampleService(
    private val applicationEventPublisher: ApplicationEventPublisher,
) {

    @Transactional
    fun success() {
        println("===> success 실행")
        println("...실행중 ....")

        applicationEventPublisher.publishEvent(
            OrderCommitEvent(orderCode = "order_1")
        )

        println("===> success 종료")
    }

    @Transactional
    fun exception() {
        println("===> exception 실행")
        println("...실행중 ....")

        applicationEventPublisher.publishEvent(
            OrderCommitEvent(orderCode = "order_1")
        )

        throw IllegalArgumentException("예외 발생!!!")
    }

    @Transactional(noRollbackFor = [IllegalArgumentException::class])
    fun noRollbackTransaction() {
        println("===> noRollbackTransaction 실행")
        println("...실행중 ....")

        applicationEventPublisher.publishEvent(
            OrderCommitEvent(orderCode = "order_1")
        )

        throw IllegalArgumentException("예외 발생!!!")
    }
}
