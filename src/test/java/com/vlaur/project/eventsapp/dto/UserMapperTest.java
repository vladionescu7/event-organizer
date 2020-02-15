package com.vlaur.project.eventsapp.dto;

import com.vlaur.project.eventsapp.UnitTest;
import com.vlaur.project.eventsapp.dto.user.UserRequest;
import com.vlaur.project.eventsapp.dto.user.UserResponse;
import com.vlaur.project.eventsapp.dto.user.UserMapper;
import com.vlaur.project.eventsapp.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserMapperTest extends UnitTest {

    private UserMapper mapper;

    @BeforeEach
    public void before() {
        mapper = new UserMapper();
    }


    @Test
    void givenUserRequest_whenToEntityIsCalled_ThenUserIsCreatedCorrectly() {
        //GIVEN

        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName("ion");
        userRequest.setLastName("popescu");

        //WHEN
        User user = mapper.toEntity(userRequest);

        //THEN
        assertThat(user.getFirstName()).isEqualTo(userRequest.getFirstName());
        assertThat(user.getLastName()).isEqualTo(userRequest.getLastName());

    }

    @Test
    void givenUser_whenToDtoIsCalled_ThenUserDtoIsCreateCorreclty() {
        //GIVEN
        User user = new User();
        user.setFirstName("ion");
        user.setLastName("vasile");
        //WHEN
        UserResponse userResponse = mapper.toDto(user);

        //THEN
        assertThat(userResponse.getFirstName()).isEqualTo(user.getFirstName());
        assertThat(userResponse.getLastName()).isEqualTo(user.getLastName());
    }

}