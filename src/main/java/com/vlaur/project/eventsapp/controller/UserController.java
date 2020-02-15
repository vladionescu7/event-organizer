package com.vlaur.project.eventsapp.controller;


import com.vlaur.project.eventsapp.model.User;
import com.vlaur.project.eventsapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    @ResponseBody
    public ResponseEntity<User> create(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    @ResponseBody
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PutMapping("/user/{id}")
    @ResponseBody
    public ResponseEntity<User> findById(@PathVariable(name = "id") Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
