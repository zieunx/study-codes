# Spring MVC

# 파라미터 바인딩

## Setter

GET API Controller를 작성할 때 다음과 같이 DTO로 받을 수 있다.

```java
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping
    public void requestProduct(
            RequestDto dto
    ) {
        log.info("dto={}", dto);
    }
}
```

```
// 요청
localhost:8080/product?name=이름

// 출력
dto=RequestDto(name=이름, description=null)
```

그 방법은 DTO에 빈생성자와 setter를 구현하면 된다.

```java
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class RequestDto {
    private String name;
    private String description;
}
```

이걸 수행하는것은 `WebBinder`

## DataBinder

DataBinder의 서브클래스 WebDataBinder가 직점 이 과정을 수행한다. 

이 과정에서 Java Bean 규약을 기준으로 바인딩을 한다.

파라미터 세팅 과정은 기본적으로 리플랙션으로 세팅되지만 getter는 안되고 setter 로 하기 때문에 꼭 setter가 있어야 한다.

## Pageable
Spring Data의 Pageable은 스프링이 기본적으로 파라미터 바인딩을 해준다.

- page
- size
- sort

```
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping
    public void requestProduct(
            Pageable page,
            RequestDto dto
    ) {
        log.info("page={}", page);
        log.info("page={}", dto);
    }
}
```