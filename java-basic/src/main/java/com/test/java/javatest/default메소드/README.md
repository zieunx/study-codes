# Java 8 에 등장한 default 메소드

> 참고 링크를 기반으로 실습 및 공부합니다.

### 참고
- [Static and Default Methods in Interfaces in Java](https://www.baeldung.com/java-static-default-methods)
- [자바는 왜 다중상속을 지원하지 않을까? (다이아몬드 문제)](https://siyoon210.tistory.com/125)

## interface default 메소드
```java
public interface GrandMather {
    default void invoke() {
        System.out.println("common invoke");
    }
}

public class Mather implements GrandMather {
    // invoke 구현하지 않음.
}

public class Main {
    public static void main(String[] args) {
        Mather mather = new Mather();
        mather.invoke(); // 상속한 부모의 default method invoke 
    }
}
```

default 메소드를 이용하면, 인터페이스를 구현하는 구현체가 강제로 메소드들 오버라이딩 하지 않아도 된다.  

### 인터페이스에 새로운 메소드가 추가되어도 구현을 강제하지 않는다.  
```java
public interface GrandMather {
    default void invoke() {
        System.out.println("common invoke");
    }

    default void run() {
        System.out.println("add run method");
    }
}

public class Mather implements GrandMather {
    // invoke 구현하지 않음.
    // 추가된 run() 메소드로 인한 구현 강제성이 없음.
}
```
인터페이스에 메소드가 추가 되면 (어쩌면 수많은) 구현체들에 추가된 메소드를 일일히 추가해주어야한다.  
일일히 구현해야했던 문제를 효율적으로 해결해준다.  
이미 구현되어있던 구현체들과의 완벽한 호환을 도와준다.

## 그럼 장점만 있을까? 다중 상속 문제
```java
public interface GrandMather {
    default void invoke() {
        System.out.println("GrandMather default invoke");
    }
}

public interface GrandMather2 {
    default void invoke() {
        System.out.println("GrandMather2 default invoke");
    }
}
```
위의 두 인터페이스를 구현하려는 클래스가 있다. 클래스는 두 인터페이스를 구현할 수 있을까?  

![인터페이스디폴트메소드다중상속 001](https://user-images.githubusercontent.com/48097396/207510950-89df8f3b-b41d-4813-a0c1-43f7abe0ebdb.png)
위의 코드를 그림으로 나타내보았다.  
애초에 Mather class 는 컴파일 에러가 발생한다.  
부모 인터페이스 각각 동일한 이름의 메소드가 구현되어있기 때문이다.  

```java
public class Mather implements GrandMather, GrandMather2 {
    @Override
    public void invoke() {
        GrandMather.super.invoke();
    }
}
```
쉬운 해결책은 자식 클래스에서 오버라이딩 하면서 어떤 부모의 메소드를 수행할 것인지 명시하는 방법이다.



## 자바는 왜 다중상속을 지원하지 않을까?
### 자바는 다중상속을 지원하지 않는다.
![다중상속 002](https://user-images.githubusercontent.com/48097396/207272598-5ff9fca7-aa5a-40ab-a9c0-9c44cfcd64de.png)
애초에 다중상속을 할 수 없도록 컴파일 에러가 난다.

### 문제가 생기는 경우를 보자.
![다중상속 001](https://user-images.githubusercontent.com/48097396/207273019-ffcfc063-74f7-4339-b642-1fe458db4a73.png)
위와 같은 다중상속이 가능하다고 가정해보자.  
최하위 클래스는 상속받는 부모로부터 어떤 invoke() 를 실행해야 하는지 알 수 없다.  
이를 `다이아몬드 문제`라고 한다.  
자바는 이러한 상속의 문제를 방지하기 위해서 다중상속을 지원하지 않고 있다.