package com.vlaur.project.eventsapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(EventRestController.API_EVENTS)
@RestController
public class EventRestController {

    public static final String API_EVENTS = "/api/events";
}
