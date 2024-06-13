package study.kotlin.event_sample

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("event")
class SampleController(
    private val sampleService: SampleService,
) {

    @PostMapping("success")
    fun success() {
        sampleService.success()
    }

    @PostMapping("exception")
    fun exception() {
        sampleService.exception()
    }

    @PostMapping("no-rollback")
    fun noRollback() {
        sampleService.noRollbackTransaction()
    }
}
