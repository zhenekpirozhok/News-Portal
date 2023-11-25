package com.newsportal.controller;

import com.newsportal.dto.UserCreateDTO;
import com.newsportal.dto.UserDTO;
import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return userService.findUserById(id)
                .map(user -> new UserDTO(user.getUsername(), user.getEmail())) // Convert User to UserDTO
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        userService.createUser(userCreateDTO.getUsername(), userCreateDTO.getPassword(), userCreateDTO.getEmail());
        return ResponseEntity.ok("User created successfully");
    }

    @PostMapping("/create_waiting")
    public ResponseEntity<String> createWaiting(@RequestBody UserCreateDTO userCreateDTO) {
        userService.createWaiting(userCreateDTO.getUsername(), userCreateDTO.getPassword(), userCreateDTO.getEmail());
        return ResponseEntity.ok("Waiting created successfully");
    }

}