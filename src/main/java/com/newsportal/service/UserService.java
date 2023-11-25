package com.newsportal.service;

import com.newsportal.model.User;
import com.newsportal.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }
    @Transactional
    public  void createUser(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole("user");
        user.setStatus(1);
        // createdAt and updatedAt are handled automatically
        userRepository.save(user);
    }
}