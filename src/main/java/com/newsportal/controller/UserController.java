package com.newsportal.controller;

import com.newsportal.dto.UserCreateDTO;
import com.newsportal.dto.UserDTO;
import com.newsportal.dto.UserUpdateDTO;
import com.newsportal.model.User;
import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User item deleted successfully");
    }

    @GetMapping("/admins")
    public ResponseEntity<List<User>> getAllAdminUsers() {
        return ResponseEntity.ok(userService.getAllAdminUsers());
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/waiting")
    public ResponseEntity<List<User>> getAllWaitingUsers() {
        return ResponseEntity.ok(userService.getAllWaitingUsers());
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateUSer(@RequestBody UserUpdateDTO userUpdateDTO) {
        userService.updateUser(userUpdateDTO);
        return ResponseEntity.ok("User updated successfully");
    }
}