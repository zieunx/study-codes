package study.kotlin.validate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import study.kotlin.dto.ProductCreateRequest
import javax.validation.Validation

class ValidationTest {
    private val valdator = Validation.buildDefaultValidatorFactory().validator

    @Nested
    inner class `@NotBlank 는` {

        @Nested
        inner class `공백 검사 시` {
            @Test
            fun `validation 수행되지 않는다`() {
                // given
                val productCreateRequest = ProductCreateRequest("")

                // when
                val validation = valdator.validate(productCreateRequest)

                // then
                assertThat(validation).hasSize(0)
            }

        }
    }
}
