package com.vlaur.project.eventsapp.service;


import com.vlaur.project.eventsapp.model.Event;
import com.vlaur.project.eventsapp.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {


    private static final Logger log = LoggerFactory.getLogger(EventService.class);

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void save(Event event) {
        log.debug(event.getName() + "created");
        eventRepository.save(event);
    }

    public List<Event> findAll() {
        log.debug("find all events");
        List<Event> events = eventRepository.findAll();

        return events;
    }

    public Event findById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("event not found"));
        return event;
    }

    public Event update(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("event not found"));

        updateEventName(event);
        Event updatedEvent = eventRepository.save(event);

        return updatedEvent;
    }

    public void updateEventName(Event event) {
        event.setName(event.getName());
    }


    public void delete(Long id) {
        log.debug("event with id" + id + "has been deleted");
        eventRepository.deleteById(id);
    }
}