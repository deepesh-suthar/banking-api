package com.deepesh.banking_api.controller;

import com.deepesh.banking_api.entity.User;
import com.deepesh.banking_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Tells Spring this class creates REST APIs
@RequestMapping("/api/users") // Base URL: http://localhost:8080/api/users
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 1. Register a new user
    // POST http://localhost:8080/api/users/register
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // 2. Get all users (For testing)
    // GET http://localhost:8080/api/users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 3. Login API (Simple version)
    // POST http://localhost:8080/api/users/login
    @PostMapping("/login")
    public User login(@RequestBody User loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return user; // Login Success
        } else {
            throw new RuntimeException("Invalid Credentials"); // Login Failed
        }
    }
}
