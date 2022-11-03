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

### 문제 3) 참조변수가 있는 경우: 객체
참조타입의 경우 재할당될 수는 없지만 해당 객체의 상태는 변할 수 있다.
* 변경 전 코드
  * `Person` 객체: `getter`만 제공한다.
    ```java
    public class Person {
        private final String name;
        private final int age;
        private final Address address;
    
        public Person(String name, int age, Address address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    
        public Address getAddress() {
            return address;
        }
    }
    ```
  * `Address` 객체: update 메소드를 제공한다.
    ```java
    public class Address {
        private String county;
        private String state;
        private String city;
        private String zipCode;

        public Address(final String county, final String state, final String city, final String zipCode) {
            this.county = county;
            this.state = state;
            this.city = city;
            this.zipCode = zipCode;
        }

        public void update(final String county, final String state, final String city, final String zipCode) {
            this.county = county;
            this.state = state;
            this.city = city;
            this.zipCode = zipCode;
        }

        @Override
         public String toString() {
            return String.format("%s %s %s %s", county, state, city, zipCode);
        }
    }
    ```
  * 테스트 코드
    ```java
    @Test
    void 하위참조변수_변경_시_가변() {
        // when
        Address address = new Address("county", "state", "city", "zipCode");
        Person person = new Person("이름", 20, address);

        // given
        address.update("county-1", "state-1", "city-1", "zipCode-1");

        //then
        assertEquals(person.getAddress(), address);
    }
    ```
    같은 참조값을 바라보고 있어서 값이 변한다는 것을 알 수 있다.
    
### 해결 3) 불변객체의 참조변수도 불변으로 만들자.
Address 변수도 final 으로 불변화한다.
* 해결 후 코드
```java
public class Address {
    private final String county;
    private final String state;
    private final String city;
    private final String zipCode;

    public Address(final String county, final String state, final String city, final String zipCode) {
        this.county = county;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
     public String toString() {
        return String.format("%s %s %s %s", county, state, city, zipCode);
    }
}
```

### 문제 4) 참조변수가 있는 경우: 컬렉션
컬렉션 참조변수의 경우를 알아보자.
* 변경 전 코드
  * `Person` 객체: `containsHobby()` 로 확인하려는 `Hobby`를 포함 여부만 리턴해준다.
    ```java
    public class Person {
        private final String name;
        private final int age;
        private final Address address;
        private final List<Hobby> hobbies;
    
        public Person(String name, int age, Address address, List<Hobby> hobbies) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.hobbies = hobbies;
        }
    
        public boolean containsHobby(Hobby hobby) {
            return hobbies.contains(hobby);
        }
    }
    ```
  * 테스트 코드
    ```java
    @Test
    void 컬렉션참조변수에_요소추가하면_가변() {
        // when
        Address address = new Address("county", "state", "city", "zipCode");
        List<Hobby> hobbies = new ArrayList<>();
        hobbies.add(new Hobby("클라이밍"));
        hobbies.add(new Hobby("독서"));
        Person person = new Person("이름", 20, address, hobbies);

        // given
        Hobby requestHobby = new Hobby("코딩");
        hobbies.add(requestHobby);

        // then
        assertTrue(person.containsHobby(requestHobby));
    }
    ```
    밖에서 컬렉션에 요소를 추가하면 해당 값을 참조하는 불변하려는객체의 컬렉션요소도 가변이다.

### 해결 4-1) `new ArrayList<>(target)` 로 생성

* 변경 후 코드
```java
public Person(String name, int age, Address address, List<Hobby> hobbies) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.hobbies = new ArrayList<>(hobbies); // 새롭게 생성
}
```
위의 테스트를 다시 실행하면 실패한다.

### 해결 4-2) `getter` 사용하는 경우, `Collections.unmodifiableList()` 활용하자.
`4-1` 의 방법을 사용하더라도 `getter` 로 컬렉션을 반환하면 여전히 불변이 지켜지지 않는다. `getter` 로 컬렉션을 반환할 땐 `Collections.unmodifiableList()`를 활용하자.
```java
public List<Hobby> getHobbies() {
    return Collections.unmodifiableList(hobbies);
}
```

### 해결 4-3) (자바10 부터 가능) `List.copyOf(tatget)` 으로 불변컬렉션 생성
`자바10` 부터는 생성할 때 부터 복사생성 할 때 부터 불변 객체를 만들어주는 메소드가 추가되었다. 자바8 이후의 `LTS`인 자바11, 자바17을 사용하면 해당 메소드를 활용할 수 있겠다.
* 변경 후 코드
```java
public Person(String name, int age, Address address, List<Hobby> hobbies) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.hobbies = List.copyOf(hobbies); // List.copyOf() 활용
}
```

* List.copyOf() 코드
```java
static <E> List<E> copyOf(Collection<? extends E> coll) {
    return ImmutableCollections.listCopy(coll);
}
```
`List` 의 `copyOf()` 는 수정이 불가한 컬렉션을 반환한다.
