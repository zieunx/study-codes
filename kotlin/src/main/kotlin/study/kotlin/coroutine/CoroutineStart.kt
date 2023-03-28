package study.kotlin.coroutine

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
suspend fun main(args: Array<String>) {
    println("Start Main Thread")
    GlobalScope.launch {
        delay(1000)
        println("in Coroutine ...")
    }
    println("End Main Thread")

    delay(3000)
}
