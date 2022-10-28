# volatile

volatile 가 무엇인지, 어떻게 동작하는지 알아보자.

## 메모리 구조
![CPU메모리구조_이미지](https://www.baeldung.com/wp-content/uploads/2017/08/cpu.png)

- 관련성 높은 데이터를 캐싱한다.
- 이점: 전체 성능 향상
- 주의사항: 캐시 일관성 문제 발생

## 예제 코드
[MultiThreadCacheTest.java 코드](./MultiThreadCacheTest.java)
```java
public class MultiThreadCacheTest {
    private static boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread increaseNumberThread = new Thread(() -> {
            int number = 0;
            while (running) {
                number++;
            }
            System.out.printf("stop Thread. number=%d", number);
        });

        increaseNumberThread.start();
        TimeUnit.SECONDS.sleep(1);
        running = false;
    }
}
```
위의 코드는 1초 후에 `increaseNumberThread`의 while문을 종료하기 위해 `running`값을 `false`로 변경한다.  
하지만, `increaseNumberThread` 스레드는 종료되지 않는다.

## 메모리 가시성
- 메인 스레드는 캐시에 *`running`* 변수의 복사본을 올려놓는다.
- `increaseNumberThread`도 캐시에 복사본을 올려놓는다.
- 메인 스레드는 캐시된 값을 업데이트 한다.
- 쓰기요청은 바로 적용되지 않는다. 쓰기 버퍼에 대기시킨다.

즉, 다른 스레드가 변경한 데이터를 읽는다는 보장이없다. 가시성에 의존하는 프로그램은 주의가 필요하다.


## 참고
https://www.baeldung.com/java-volatile