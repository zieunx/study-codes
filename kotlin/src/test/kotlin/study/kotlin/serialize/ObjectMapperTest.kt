package study.kotlin.serialize;

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ObjectMapperTest {

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun `jsonString 의 LocalDateTime 프로퍼티 parsing`() {
        val jsonString = """
            { "name": "홍길동", "dateOfBirth": "2023-07-13T00:51:12" }
        """.trimIndent()

        val result = objectMapper.readValue(jsonString, Person::class.java)

        println("result: $result")
    }
}
