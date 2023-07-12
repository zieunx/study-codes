package study.kotlin.serialize

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.joda.JodaModule
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JacksonConfig {

    @Bean("objectMapper")
    @ConditionalOnMissingBean
    fun objectMapper(): ObjectMapper = JsonMapper
        .builder()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false)
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
//        .addModule(JsonOrgModule())
        .addModule(JodaModule())
        .addModule(JavaTimeModule())
        .addModule(KotlinModule.Builder().configure(KotlinFeature.NullIsSameAsDefault, enabled = true).build())
        .build()
}
