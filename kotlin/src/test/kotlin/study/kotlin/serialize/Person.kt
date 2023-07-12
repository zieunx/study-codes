package study.kotlin.serialize

import java.time.LocalDateTime

data class Person(
    val name: String?,
    val address: String?,
    val phone: String?,
    val dateOfBirth: LocalDateTime?,
)
