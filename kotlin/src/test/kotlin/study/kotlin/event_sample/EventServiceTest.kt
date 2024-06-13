package study.kotlin.event_sample

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class EventServiceTest {

    @Autowired
    private lateinit var eventService: EventService

    @MockBean
    private lateinit var eventHandler: OrderCommitEventHandler

    @Test
    fun `트랜잭션이 정상 커밋되면, AFTER_COMMIT 헨들러가 실행된다`() {
        // given
        val event = OrderCommitEvent(orderCode = "order_1")

        // when
        eventService.success(event)

        // then
        verify(eventHandler, times(1))
            .handleEventAfterCommit(event)
    }

    @Test
    fun `예외가 발생하면, AFTER_ROLLBACK 헨들러가 실행된다`() {
        // given
        val event = OrderCommitEvent(orderCode = "order_1")

        // when
        assertThrows<IllegalArgumentException> {
            eventService.exception(event)
        }

        // then
        verify(eventHandler, times(1))
            .handleAfterRollback(event)
    }

    @Test
    fun `noRollback 로 설정한 예외가 발생하면, AFTER_COMMIT 헨들러가 실행된다`() {
        // given
        val event = OrderCommitEvent(orderCode = "order_1")

        // when
        assertThrows<IllegalArgumentException> {
            eventService.noRollbackTransaction(event)
        }

        // then
        // AFTER_ROLLBACK 이벤트 리스너가 호출되지 않음을 확인
        verify(eventHandler, never())
            .handleAfterRollback(event)

        // AFTER_COMMIT 이벤트 리스너가 호출되었음을 확인
        verify(eventHandler, times(1))
            .handleEventAfterCommit(event)
    }
}
