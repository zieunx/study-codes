package com.test.java.javatest.동기화.event.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "event")
public class Event {

    @Id
    private Integer id;

    @Column(unique = true)
    private String code;

    private String name;

    private Integer max;

    private Integer count;

    public void apply() {
        count -= 1;
    }
}
