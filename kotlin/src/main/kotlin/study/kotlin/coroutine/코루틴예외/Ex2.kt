package study.kotlin.coroutine.코루틴예외

import kotlinx.coroutines.*
fun main() {
    runBlocking {
        ex2()
    }
}

/**
 * SupervisorJob 활용
 */
suspend fun ex2() {
    val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    scope.launch {
        delay(600L)
        println("A: ${Thread.currentThread().name}")
    }

    scope.launch {
        delay(500L)
        throw IllegalArgumentException("코루틴 실패!")
    }

    delay(1000L) // 메인 코루틴 종료 딜레이
}
