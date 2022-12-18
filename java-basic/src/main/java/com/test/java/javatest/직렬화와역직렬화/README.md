# 직렬화와 역직렬화

### 참고
- [Java Documentation - Java Object Serialization](https://docs.oracle.com/javase/8/docs/technotes/guides/serialization/index.html)
- [자바 직렬화, 그것이 알고싶다. 실무편](https://techblog.woowahan.com/2551/)

## 직렬화와 역직렬화
공식 문서에서 다음으로 설명한다.
> Object Serialization supports the encoding of objects and the objects reachable from them, into a stream of bytes. Serialization also supports the complementary reconstruction of the object graph from a stream. Serialization is used for lightweight persistence and for communication via sockets or Java Remote Method Invocation (Java RMI). The default encoding of objects protects private and transient data, and supports the evolution of the classes. A class may implement its own external encoding and is then solely responsible for the external format.

- 직렬화는 객체를 바이트 스트림으로 인코딩 하는 것
- 스트림의 객체 그래프 보완 구성 해줌 (?)
- 경량지속성 / 소캣 / Java RMI 를 통한 통신에 사용


## Serializable 인터페이스

자바에서 직렬화를 하기 위해서는 `Serializable` 인터페이스를 구현해야한다.  
`Serializable` 인터페이스를 알아보기 위해 