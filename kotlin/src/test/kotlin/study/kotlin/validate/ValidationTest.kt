package study.kotlin.validate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import study.kotlin.dto.ProductCreateRequest
import javax.validation.Validation

class ValidationTest {
    private val valdator = Validation.buildDefaultValidatorFactory().validator

    @Test
    fun `상품 생성 요청 시, name이 null 이거나 공백이면, 예외가 발생한다`() {
        // given
        val productCreateRequest = ProductCreateRequest("")
        val validation = valdator.validate(productCreateRequest)

        // when
        assertThat(validation).hasSize(1)

        // then
        for (fail in validation) {
            assertThat(fail.message).isEqualTo("상품명은 필수값입니다.")
        }
    }
}
