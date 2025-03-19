package com.test.java.javatest.동기화.event.controller;

import com.test.java.javatest.동기화.event.dto.CouponIssueRequest;
import com.test.java.javatest.동기화.event.service.EventService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("issue/{eventCode}")
    public String issue(@PathVariable String eventCode,@RequestBody CouponIssueRequest request) {
        return eventService.apply(eventCode, request.getUserId());
    }
}
