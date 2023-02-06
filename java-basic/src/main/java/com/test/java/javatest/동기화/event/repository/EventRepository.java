package com.test.java.javatest.동기화.event.repository;

import com.test.java.javatest.동기화.event.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    Optional<Event> findByCode(String code);
}
