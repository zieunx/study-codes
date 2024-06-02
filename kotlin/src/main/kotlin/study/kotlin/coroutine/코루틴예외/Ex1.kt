package study.kotlin.coroutine.코루틴예외

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        ex1()
    }
}

/**
 * 예외전파로인해_다른코루틴실행이_실패해버림
 */
suspend fun ex1() {
    val scope = CoroutineScope(Dispatchers.Default)

    // 프린트 출력되길 바라는 스코프
    val result1 = scope.async {
        delay(600L)
        println("A: ${Thread.currentThread().name}")
    }

    // 예외를 터트리는 스코프
    val result2 = scope.async {
        delay(500L)
        throw IllegalArgumentException("코루틴 실패!")
    }

    result1.await()
    result2.await()
}
