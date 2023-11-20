# 코틀린에서 JPA 사용하기

JPA는 자바언어와의 호환성이 크기 때문에 코틀린에서 사용하기 위해서는 몇 가지 주의사항이 필요하다.

## 생성자

### JPA Entity 클래스는 public 또는 protected 여야 한다.
코틀린은 문법상 프로퍼티를 선언하면서 자동으로 생성되는 생성자 한개를 사용하는 경우가 많다.
추가적인 생성자는 반드시 기본 생성자를 상속해야 하는 문법이다.
그래서 매개변수가 없는 생성자를 작성하는 것이 번거로움.

추가적인 플러그인을 적용하면 아래의 어노테이션이 붙은 클래스에 자동으로 매개변수가 없는 생성자를 만들어줌.

- @Entity
- @Embeddable
- @MappedSuperclass

```groovy
plugins {
    id 'org.jetbrains.kotlin.plugin.jpa' version '{Kotlin버전}'
}
```

```kotlin
plugins {
    ...
    kotlin("plugin.jpa") version "{Kotlin버전}"
    ...
}
```

### 지연로딩을 사용하려면 엔티티 클래스가 final이면 안된다.

코틀린의 모든 클래스는 기본적으로 final.
@OneToMany 일 때는 final이어도 가능하지만 @ManyToOne 일 때는 지연로딩이 작동하지 않음.

엔티티마다 open을 붙혀주면 되지만 번거로운 작업이다.


```groovy
plugins {
    ...
    id 'org.jetbrains.kotlin.plugin.spring' version '1.7.22'
    ...
}
```

이 플러그인은 all-open을 포함하고 있음.

- spring boot 3.0.0 이상: jakarta
- spring boot 3.0.0 미만: javax

```groovy
// 3.0.0 미만
plugins {
    ...
    id 'org.jetbrains.kotlin.plugin.allopen' version '{Kotlin버전}'	// Gradle(Groovy)
    kotlin("plugin.allopen") version "{Kotlin버전}"	// Gradle(Kotlin)
    ...
}

allOpen {
    annotation("javax.persistence.Entity") // 3.0.0 이상은 javax 를 jakarta로 변경
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}
```



### 참고글

- javax 와 jakarta의 차이
  - https://www.samsungsds.com/kr/insights/java_jakarta.html
    - 대충 요약해보자면 오라클에서 Java EE 8 릴리즈를 마지막으로 비영리단체인 이클립스 재단에 Java EE 프로젝트를 이관했음(이유는 오라클의 수익화 실패). 이관된 JavaEE의 공식 명칙은 Jakarta EE. 그래서 JavaEE 8의 패키지명 javax를 Jakarta EE 9부터 jakarta로 변경함.
