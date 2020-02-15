package com.vlaur.project.eventsapp.controller;

import com.vlaur.project.eventsapp.RestIntegrationTest;
import com.vlaur.project.eventsapp.dto.user.UserMapper;
import com.vlaur.project.eventsapp.dto.user.UserResponse;
import com.vlaur.project.eventsapp.model.User;
import com.vlaur.project.eventsapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.vlaur.project.eventsapp.controller.UserRestController.API_USER;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserRestControllerTest extends RestIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void givenExistingUser_whenGetUserById_thenReturnUser() {
        //given
        User expectedUser = new User();
        expectedUser.setFirstName("Gigel");
        expectedUser.setLastName("Popescu");
        expectedUser = userRepository.save(expectedUser);
        UserResponse expectedResult = userMapper.toDto(expectedUser);

        //when
        String relativePath = API_USER + "/" + expectedUser.getId();
        ResponseEntity<UserResponse> responseEntity = this.restTemplate
                .getForEntity(url(relativePath), UserResponse.class);

        //then

        assertEquals(expectedResult, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}