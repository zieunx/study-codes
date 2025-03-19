package com.test.java.javatest.직렬화와역직렬화.code;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private String name;
    private String password;
    private int age;
    transient private Object object; // 직렬화 대상에서 제외
}
