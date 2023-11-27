package com.newsportal.controller;

import com.newsportal.dto.UserCreateDTO;
import com.newsportal.dto.UserDTO;
import com.newsportal.dto.UserUpdateDTO;
import com.newsportal.model.User;
import com.newsportal.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private HttpSession session;
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return userService.findUserById(id)
                .map(user -> new UserDTO( user.getUsername(), user.getEmail(), user.getRole())) // Convert User to UserDTO
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getCurrentUserProfile() {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User is not logged in.");
        }
        UserDTO userDTO = new UserDTO( currentUser.getUsername(), currentUser.getEmail(), currentUser.getRole());
        return ResponseEntity.ok(userDTO);
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable Long id) {
        if (!userService.isCurrentUserAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
        userService.deleteUser(id);
        return ResponseEntity.ok("User item deleted successfully");
    }

    @GetMapping("/admins")
    public ResponseEntity<?> getAllAdminUsers() {
      if (!userService.isCurrentUserAdmin()) {

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
        return ResponseEntity.ok(userService.getAllAdminUsers());
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        if (!userService.isCurrentUserAdmin()) {

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/waiting")
    public ResponseEntity<?> getAllWaitingUsers() {
        if (!userService.isCurrentUserAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
        return ResponseEntity.ok(userService.getAllWaitingUsers());
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateUSer(@RequestBody UserUpdateDTO userUpdateDTO) {
        if (!userService.isCurrentUserAdmin()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied.");
        }
        userService.updateUser(userUpdateDTO);
        return ResponseEntity.ok("User updated successfully");
    }



}
