package study.kotlin.validate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import study.kotlin.dto.ProductCreateRequest
import study.kotlin.dto.ProductNotNullRequest
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
                val productCreateRequest = ProductCreateRequest(" ")

                // when
                val violations = valdator.validate(productCreateRequest)

                // then
                assertThat(violations)
                    .extracting("message")
                    .contains("상품명은 필수값입니다.")
            }

        }
    }

    @Nested
    inner class `nullable이 아닌 필드는` {

        @Nested
        inner class `유효성 검사 시`{

            @Test
            fun `type mismatching 에러가 먼저 발생한다`() {
//                ProductNotNullRequest()
//                val violations = valdator.validate(productCreateRequest)
            }
        }
    }
}
