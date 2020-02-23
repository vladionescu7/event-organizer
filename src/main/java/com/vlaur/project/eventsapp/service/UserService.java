package com.vlaur.project.eventsapp.service;

import com.vlaur.project.eventsapp.model.User;
import com.vlaur.project.eventsapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        log.debug(user.getUsername() + "created");
        return userRepository.save(user);

    }

    public List<User> findAll() {
        log.debug("find all users..");
        List<User> users = userRepository.findAll();

        return users;
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User update(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));

        updateUsername(user);

        User updatedUser = userRepository.save(user);

        return updatedUser;
    }

    public void updateUsername(User user) {
        user.setUsername(user.getUsername());
    }

    public void delete(Long id) {
        log.debug("user with id: " + id + " has been deleted");
        userRepository.deleteById(id);
    }
}
