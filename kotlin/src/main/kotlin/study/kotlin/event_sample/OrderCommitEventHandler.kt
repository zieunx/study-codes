package study.kotlin.event_sample

import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class OrderCommitEventHandler {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun handleEventAfterCommit(event: OrderCommitEvent) {
        println("~~ 트랜잭션 커밋 후 실행 😀 ~~")
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    fun handleAfterRollback(event: OrderCommitEvent) {
        println("~~ ❗️트랜잭션이 롤백 후 실행 ❗️ ~~")
    }
}
