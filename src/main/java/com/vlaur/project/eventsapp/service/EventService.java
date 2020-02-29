package com.vlaur.project.eventsapp.service;


import com.vlaur.project.eventsapp.model.Event;
import com.vlaur.project.eventsapp.model.User;
import com.vlaur.project.eventsapp.repository.EventRepository;
import com.vlaur.project.eventsapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {


    private static final Logger log = LoggerFactory.getLogger(EventService.class);

    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Autowired
    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Event save(Event event) {
        log.debug(event.getName() + "created");
        Long userId = event.getOrganizer().getId();
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new RuntimeException("User with id " + userId + " does not exist"));
        event.setOrganizer(user);
        return eventRepository.save(event);
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