package study.kotlin.coroutine

import kotlinx.coroutines.*

fun main() = runBlocking {
    val scope = CoroutineScope(Dispatchers.Default)

    // 코루틴 1 생성 및 실행
    scope.launch {
        // 코루틴 1 내부의 코드
        println("Coroutine 1 is running")
        delay(1000L)
        println("Coroutine 1 is finished")
    }

    // 코루틴 2 생성 및 실행
    scope.launch {
        // 코루틴 2 내부의 코드
        println("Coroutine 2 is running")
        delay(2000L)
        println("Coroutine 2 is finished")
    }

    // 코루틴들이 모두 종료될 때까지 기다림
    delay(3000L)
}
