# 불변 객체

<aside>
💡가변객체로 시작해서 단계적으로 불변객체를 만들어보자.
</aside>

가변 객체

1) 객체의 변수가 `public`인 경우  
-> 외부에서 값을 변경할 수 있다.

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


2) `setter` 가 있는 경우  
    -> 외부에서 값을 변경할 수 있다.

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
        person.setAge(21);
    }
}
```