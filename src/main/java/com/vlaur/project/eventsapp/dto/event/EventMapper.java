package com.vlaur.project.eventsapp.dto.event;

import com.vlaur.project.eventsapp.dto.user.UserMapper;
import com.vlaur.project.eventsapp.dto.user.UserResponse;
import com.vlaur.project.eventsapp.model.Event;
import com.vlaur.project.eventsapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapper {

    @Autowired
    public UserMapper userMapper;


    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Event toEntity(EventRequest eventRequest) {
        Event event = new Event();
        User user = new User();
        user.setId(eventRequest.getOrganiserId());

        event.setName(eventRequest.getName());
        event.setAccess(eventRequest.getAccess());
        event.setAddress(eventRequest.getAddress());
        event.setDate(LocalDate.parse(eventRequest.getDate(), dateTimeFormatter));
        event.setOrganizer(user);
        return event;
    }

    public List<Event> toEntity(List<EventRequest> eventRequests) {
        List<Event> events = new ArrayList<>();
        for (EventRequest eventRequest : eventRequests) {
            events.add(toEntity(eventRequest));
        }
        return events;
    }

    public EventResponse toDto(Event event) {
        EventResponse dto = new EventResponse();
        dto.setName(event.getName());
        dto.setDate(event.getDate().format(dateTimeFormatter));
        dto.setAddress(event.getAddress());
        dto.setAccess(event.getAccess());
        UserResponse organiser = userMapper.toDto(event.getOrganizer());
        dto.setOrganiser(organiser);

        return dto;
    }

    public List<EventResponse> toDto(List<Event> events) {
        return events.stream()
                .map(this::toDto)
                .collect(Collectors.toList());

    }
}
