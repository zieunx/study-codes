# Kotlin

- [공식문서](https://kotlinlang.org/docs/home.html)


### null 안정성과 request 유효성 검사

코틀린은 null을 허용할 때 타입 끝에 `?` 를 해주어야한다.
`?` 를 붙히지 않으면 Null을 허용하지 않는다.

> <관련문서>
> - [공식문서:Nullable values and null checks](https://kotlinlang.org/docs/basic-syntax.html#nullable-values-and-null-checks)
> - [공식문서:Null safety](https://kotlinlang.org/docs/null-safety.html#nullable-types-and-non-nullable-types)

Spring을 쓰는 경우 `spring-boot-starter-validation` 를 사용하여 검증을 하는 경우가 일반적이다.

```kotlin
import javax.validation.constraints.NotBlank

data class ProductNoneNullRequest (
    @field:NotBlank(message = "상품명은 필수값입니다.")
    val productName: String
)

```
이 코드는 정상적으로 validation이 활용이 될까?

일단, 생성자를 통해 생성 시, 값을 강제로 넣어야하니 validation 테스트가 불가하다.

controller 테스트를 진행해야함.


```kotlin

```

테스트 결과 다음 예외 발생.

> org.springframework.http.converter.HttpMessageNotReadableException


```kotlin

```

테스트 결과 다음 예외 발생.

> org.springframework.http.converter.HttpMessageNotReadableException
