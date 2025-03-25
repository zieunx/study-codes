package com.test.java.javatest.동기화.event.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event_participant")
public class EventParticipant {

    @Id
    private int id;

    private String memberId;
}
