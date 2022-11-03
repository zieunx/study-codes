# 불변 객체

<aside>
💡가변객체로 시작해서 단계적으로 불변객체를 만들어보자.
</aside>

가변 객체

### 문제 1) 객체의 변수가 `public`인 경우
문제: 외부에서 값을 변경해버릴 수 있다.
 * 변경 전 코드
```java
public class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ImmutableMain {
    public static void main(String[] args) {
        Person person = new Person("길동이", 20);
        person.age = 21;
    }
}
```

### 해결 1) `private` 접근자로 바꾸자.

외부에서 변수에 바로 접근할 수 없어진다.

* 변경 후 코드
```java
public class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ImmutableMain {
    public static void main(String[] args) {
        Person person = new Person("길동이", 20);
        person.age = 21;
    }
}
```


### 문제 2) `setter` 가 있는 경우

변경의 주체는 객체 자신에게 있지만, 여전히 setter 메소드를 통해 값이 변경된다.

```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class ImmutableMain {
    public static void main(String[] args) {
        Person person = new Person("길동이", 20);
        person.setAge(21); // 외부에서 값 변경 메소드 호출 
    }
}
```

### 해결 2) `final` 을 추가하자.
초기화 이후로는 변수를 재할당할 수 없게 된다.

**final을 통해 기대할 수 있는 부분**
1. 생성자 초기화를 강제한다.
2. setter 등 재할당할 수 없어진다.

* 변경 후 코드
```java
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
    public void setAge(int age) {
        this.age = age;  // error ~!
    }
    */
}
```

### 문제 3) 참조타입이 있는 경우
참조타입의 경우 재할당될 수는 없지만 해당 객체의 상태는 변할 수 있다.
* 변경 전 코드
```java

```