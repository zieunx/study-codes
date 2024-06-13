package study.kotlin.event_sample

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("event")
class EventController(
    private val eventService: EventService,
) {

    @PostMapping("success")
    fun success() {
        eventService.success(
            OrderCommitEvent(orderCode = "order_1")
        )
    }

    @PostMapping("exception")
    fun exception() {
        eventService.exception(
            OrderCommitEvent(orderCode = "order_1")
        )
    }

    @PostMapping("no-rollback")
    fun noRollback() {
        eventService.noRollbackTransaction(
            OrderCommitEvent(orderCode = "order_1")
        )
    }
}
