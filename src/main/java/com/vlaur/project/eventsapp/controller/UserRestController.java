package com.vlaur.project.eventsapp.controller;

import com.vlaur.project.eventsapp.dto.user.UserMapper;
import com.vlaur.project.eventsapp.dto.user.UserRequest;
import com.vlaur.project.eventsapp.dto.user.UserResponse;
import com.vlaur.project.eventsapp.model.User;
import com.vlaur.project.eventsapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(UserRestController.API_USER)
@RestController
public class UserRestController {
    public static final String API_USER = "/api/users";
    private UserService userService;
    private UserMapper userMapper;
    @Autowired
    public UserRestController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }


    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        User user = userMapper.toEntity(request);
        User savedUser = userService.save(user);
        UserResponse userResponse = userMapper.toDto(savedUser);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        List<User> users = userService.findAll();
        List<UserResponse> usersResponse = userMapper.toDto(users);
        return new ResponseEntity<>(usersResponse, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> findByUsername(@PathVariable(name = "username") String username) {
        return userService.findByUsername(username)
                .map(userMapper::toDto)
                .map(userResponse -> new ResponseEntity<>(userResponse, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>("user deleted", HttpStatus.OK);
    }
}
