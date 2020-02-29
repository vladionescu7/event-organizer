package com.vlaur.project.eventsapp.controller;

import com.vlaur.project.eventsapp.RestIntegrationTest;
import com.vlaur.project.eventsapp.dto.event.EventRequest;
import com.vlaur.project.eventsapp.dto.event.EventResponse;
import com.vlaur.project.eventsapp.model.Access;
import com.vlaur.project.eventsapp.model.User;
import com.vlaur.project.eventsapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

class EventRestControllerTest extends RestIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;


    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Test
    void givenEvent_whenCreateEventIsCalled_thenEventIsCreated() {
        //given
        User user = new User();
        user.setFirstName("first name");
        user.setLastName("last name");
        User savedUser = userRepository.save(user);

        EventRequest eventRequest = new EventRequest();
        eventRequest.setName("my event");
        eventRequest.setAddress("here");
        eventRequest.setDate(LocalDate.now().format(dateTimeFormatter));
        eventRequest.setAccess(Access.PUBLIC);
        eventRequest.setOrganiserId(savedUser.getId());

        //when
        ResponseEntity<EventResponse> responseEntity =
                testRestTemplate.postForEntity(EventRestController.API_EVENTS, eventRequest, EventResponse.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(responseEntity.getBody().getName()).isEqualTo(eventRequest.getName());
        assertThat(responseEntity.getBody().getAddress()).isEqualTo(eventRequest.getAddress());
        assertThat(responseEntity.getBody().getAccess()).isEqualTo(eventRequest.getAccess());
        assertThat(responseEntity.getBody().getOrganiser().getId()).isEqualTo(eventRequest.getOrganiserId());
        assertThat(responseEntity.getBody().getOrganiser().getFirstName()).isEqualTo(user.getFirstName());
        assertThat(responseEntity.getBody().getOrganiser().getLastName()).isEqualTo(user.getLastName());
        assertThat(responseEntity.getBody().getDate()).isEqualTo(eventRequest.getDate());
    }

}