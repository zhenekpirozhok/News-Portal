package com.newsportal.controller;

import com.newsportal.dto.LoginDTO;
import com.newsportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        if (userService.loginUser(loginDTO.getUsername(), loginDTO.getPassword())) {
            return ResponseEntity.ok("User logged in successfully.");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        userService.logoutUser();
        return ResponseEntity.ok("User logged out successfully.");
    }
}
