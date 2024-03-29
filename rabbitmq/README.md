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

## DLQ

일정 시간이 지나면 메시지를 처리할 수 있도록 설계할 수 있다.

- `x-dead-letter-exchange` : DLQ 로 메시지를 보낼 exchange
- `x-dead-letter-routing-key` : DLQ 로 메시지를 보낼 routing key
- `x-message-ttl` : 메시지의 TTL (Time To Live)

이 설정으로 Queue를 등록하면, 메시지는 최대 10초 동안 큐에 머무를 수 있다.  
10초가 지나면 메시지는 처리되지 않은 상태로 큐에서 제거되고, 설정된 Dead Letter Exchange를 통해 Dead Letter Queue로 전달된다.
