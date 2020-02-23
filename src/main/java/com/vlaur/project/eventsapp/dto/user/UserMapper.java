package com.vlaur.project.eventsapp.dto.user;

import com.vlaur.project.eventsapp.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User toEntity(UserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        // user.setPassword(userRequest.getPassword());
        user.setUsername(userRequest.getUsername());
        user.setDateOfBirth(userRequest.getDateOfBirth());
        return user;
    }

    public List<User> toEntity(List<UserRequest> userRequests) {
        List<User> users = new ArrayList<>();
        for (UserRequest userRequest : userRequests) {
            users.add(toEntity(userRequest));
        }
        return users;
    }


    public List<UserResponse> toDto(List<User> users) {
        return users.stream()
                .map(this::toDto)
                .collect(Collectors.toList());

    }

    public UserResponse toDto(User user) {
        UserResponse dto = new UserResponse();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setDateOfBirth(user.getDateOfBirth());

        return dto;
    }
}
