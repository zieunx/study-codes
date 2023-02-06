package com.test.java.javatest.동기화.event.service;

import com.test.java.javatest.동기화.event.domain.Event;
import com.test.java.javatest.동기화.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;

    @Transactional
    public String apply(String eventCode, String userId) {
        // 정원초과여부
        Event event = eventRepository.findByCode(eventCode)
                .orElseThrow(() -> new EntityNotFoundException("이벤트를 찾을 수 없습니다."));

        event.apply();

        return userId + "이벤트 신청 완료";
    }
}
