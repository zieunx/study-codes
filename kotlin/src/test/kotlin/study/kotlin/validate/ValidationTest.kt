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
            fun `validation 된다`() {
                // given
                val productCreateRequest = ProductCreateRequest("")

                // when
                val violations = valdator.validate(productCreateRequest)

                // then
                assertThat(violations)
                    .extracting("message")
                    .contains("상품명은 필수값입니다.")
            }

        }
    }
}
