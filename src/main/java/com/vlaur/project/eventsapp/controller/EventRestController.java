package com.vlaur.project.eventsapp.controller;

import com.vlaur.project.eventsapp.dto.comment.CommentMapper;
import com.vlaur.project.eventsapp.dto.event.EventMapper;
import com.vlaur.project.eventsapp.dto.event.EventRequest;
import com.vlaur.project.eventsapp.dto.event.EventResponse;
import com.vlaur.project.eventsapp.dto.user.UserMapper;
import com.vlaur.project.eventsapp.model.Event;
import com.vlaur.project.eventsapp.service.CommentService;
import com.vlaur.project.eventsapp.service.EventService;
import com.vlaur.project.eventsapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(EventRestController.API_EVENTS)
@RestController
public class EventRestController {

    public static final String API_EVENTS = "/api/events";

    private EventService eventService;
    private EventMapper eventMapper;
    private CommentService commentService;
    private CommentMapper commentMapper;
    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public EventRestController(EventService eventService, EventMapper eventMapper, CommentService commentService,
                               CommentMapper commentMapper, UserService userService, UserMapper userMapper) {
        this.eventService = eventService;
        this.eventMapper = eventMapper;
        this.commentService = commentService;
        this.commentMapper = commentMapper;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<EventResponse> create(@RequestBody EventRequest eventRequest) {

        Event event = eventMapper.toEntity(eventRequest);
        Event savedEvent = eventService.save(event);
        EventResponse eventResponse = eventMapper.toDto(savedEvent);

        return new ResponseEntity<>(eventResponse, HttpStatus.CREATED);
    }
}
