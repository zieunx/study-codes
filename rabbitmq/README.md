# RabbitMQ with Spring Boot

> RabbitMQ 를 Spring Boot 환경에서 설정하고 구현하는 것을 공부합니다.

### 참고하기 좋은 링크
- [RabbitMQ 공홈 - 튜토리얼](https://www.rabbitmq.com/getstarted.html) : 예제 보면서 돌아가는 구조 참고하기 좋아보임
- [cloudamqp: Part 1: RabbitMQ for beginners - What is RabbitMQ?](https://www.cloudamqp.com/blog/part1-rabbitmq-for-beginners-what-is-rabbitmq.html): 돌아가는 로직에 대한 전반적인 설명

### 커넥션(Connection)

TCP 소캣을 통해 물리적 연결 

### 채널

커넥션 위에서 동작하는 가상 통신 경로

- TCP 연결 재사용하기 위해


### CachingConnectionFactory

- RabbitMQ 와 커넥션을 생성하고 관리해준다.
- 채널을 캐싱해서 리소스 최적화
  - 하지만 thread-safe 하지는 않음

## Queue Properties

- name: 이름
- durable: 브로커를 다시 시작해도 유지됨
- exclusive: 단 하나의 연결에서만 사용되며 해당 연결이 닫히면 대기열이 삭제됨
- auto-delete: 마지막 소비자가 구독을 취소하면 삭제됨
- arguments: (선택사항) 메시지 TTL, 대기열 길이 제한 등과 같은 플러그인 및 브로커 관련 기능에서 사용됨

**[`auto-delete` 혹은 `exclusive` 주의사항]**


`auto-delete` 혹은 `exclusive` 설정의 Queue를 서버가 지정한 이름으로 생성 시 문제가 발생할 수 있음.  
예륻 들어 큐 이름이 "my-temp-queue" 인 `auto-delete`Queue가 있다고 가정.  
하나있던 컨슈머가 연결이 끊겨서 삭제 중일 때, 서버가 재시작되면서 "my-temp-queue" 인 `auto-delete` Queue를 생성할 수 있음.  
이럴 때 예외가 발생하면서 의도대로 동작하지 않을 수 있으니 주의해야함. 보통 이런 두 가지 타입의 큐를 만들 때는 랜덤문자열을 만들어 고유의 이름을 지정하는게 일반적임.

## Dead-Letter Queue (DLQ)

일정 시간이 지나면 메시지를 처리할 수 있도록 설계할 수 있다.

- `x-dead-letter-exchange` : DLQ 로 메시지를 보낼 exchange
- `x-dead-letter-routing-key` : DLQ 로 메시지를 보낼 routing key
- `x-message-ttl` : 메시지의 TTL (Time To Live)

이 설정으로 Queue를 등록하면, 메시지는 최대 10초 동안 큐에 머무를 수 있다.  
10초가 지나면 메시지는 처리되지 않은 상태로 큐에서 제거되고, 설정된 Dead Letter Exchange를 통해 Dead Letter Queue로 전달된다.
