# 직렬화와 역직렬화

> 예전에 어떤 작은 netty 통신하는 프로젝트를 잠깐 한 적이 있다. 그 과정에서 직렬화를 제대로 이해하지 못해서 문제가 발생했고 동료에게 물어봐 해결한 경험이 있다.
> 이번 기회에 직렬화 뿌시고 가고싶다!

### 참고
- [Java Documentation - Java Object Serialization](https://docs.oracle.com/javase/8/docs/technotes/guides/serialization/index.html)
- [자바 직렬화, 그것이 알고싶다. 실무편](https://techblog.woowahan.com/2551/)

## 직렬화와 역직렬화
공식 문서에서 다음으로 설명한다.
> Object Serialization supports the encoding of objects and the objects reachable from them, into a stream of bytes. Serialization also supports the complementary reconstruction of the object graph from a stream. Serialization is used for lightweight persistence and for communication via sockets or Java Remote Method Invocation (Java RMI). The default encoding of objects protects private and transient data, and supports the evolution of the classes. A class may implement its own external encoding and is then solely responsible for the external format.

- 직렬화는 객체를 바이트 스트림으로 인코딩 하는 것
- 스트림의 객체 그래프 보완 구성 해줌 (?)
- 경량지속성 / 소캣 / Java RMI 를 통한 통신에 사용

위의 설명을 통해 조금은 가까워진 것 같다.

자바의 정석에서는 다음으로 설명한다.
- 네트워크를 통해 컴퓨터 간에 서로 객체를 주고 받을 수 있게 해준다.
- 객체를 데이터 스트림으로 만드는 것
- 스트림에 쓰기(write) 위해 연속적인(serial) 데이터로 변환하는 것
- 어렵게 느껴질 수 있는데 사실 **객체를 저장하거나 전송하려면 당연히 이렇게 할 수 밖에 없다.**


## Serializable 인터페이스

자바에서 직렬화를 하기 위해서는 `Serializable` 인터페이스를 구현해야한다.  
`Serializable` 인터페이스는 내용이 없는 빈 인터페이스이지만 직렬화를 고려하여 작성한 클래스인지 판단하는 기준이 된다.  
`Serializable` 를 구현한 클래스를 상속받으면 직렬화 가능하다.  

**Object 는 직렬화를 구현하고 있지 않는다.**  
**String 은 직렬화를 구현하고 있다.**  
타입