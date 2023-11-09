package study.kotlin.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class ProductCreateControllerTest(
    @Autowired val mockMvc: MockMvc
) {

    @Test
    fun `상품생성 - none-null`() {
        mockMvc.perform(post("/product/none-null"))
            .andExpect(status().isCreated)
    }

    @Test
    fun `상품생성 - nullable`() {
        mockMvc.perform(post("/product/nullable"))
            .andExpect(status().isCreated)
    }
}
