package com.newsportal.service;

import com.newsportal.dto.UserUpdateDTO;
import com.newsportal.model.User;
import com.newsportal.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void createUser(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole("user");
        user.setStatus(1);
        // createdAt and updatedAt are handled automatically
        userRepository.save(user);
    }

    @Transactional
    public void createWaiting(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole("waiting");
        user.setStatus(1);
        // createdAt and updatedAt are handled automatically
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public List<User> getAllAdminUsers() {
        return userRepository.findByRole("admin", Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public List<User> getAllUsers() {
        return userRepository.findByRole("user", Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public List<User> getAllWaitingUsers() {
        return userRepository.findByRole("waiting", Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public void updateUser(UserUpdateDTO userUpdateDTO) {
        userRepository.findById(userUpdateDTO.getId()).ifPresent(user -> {
            if (userUpdateDTO.getUsername() != null) user.setUsername(userUpdateDTO.getUsername());
            if (userUpdateDTO.getPassword() != null) user.setPassword(userUpdateDTO.getPassword());
            if (userUpdateDTO.getEmail() != null) user.setEmail(userUpdateDTO.getEmail());
            if (userUpdateDTO.getRole() != null) user.setRole(userUpdateDTO.getRole());
            if (userUpdateDTO.getStatus() != null) user.setStatus(userUpdateDTO.getStatus());
            if (userUpdateDTO.getCreatedAt() != null) user.setCreatedAt(userUpdateDTO.getCreatedAt());

            userRepository.save(user);
        });
    }

    @Autowired
    private HttpSession session; // Inject the session

    public boolean loginUser(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && password.matches(password)) {
            session.setAttribute("user", user.get());
            return true;
        }
        return false;
    }

    public void logoutUser() {
        session.invalidate(); // Invalidate the session
    }

    public boolean isCurrentUserAdmin() {
        User user = (User) session.getAttribute("user");
        return user != null && "admin".equals(user.getRole()) && user.getStatus() == 1;
    }

    public boolean isCurrentUserUser() {
        User user = (User) session.getAttribute("user");
        return user != null && (user.getStatus() == 1) && ("user".equals(user.getRole()) || "admin".equals(user.getRole()));
    }
}