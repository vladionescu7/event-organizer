package com.vlaur.project.eventsapp.dto.user;

import com.vlaur.project.eventsapp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public User toEntity(UserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
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

        return dto;
    }
}
