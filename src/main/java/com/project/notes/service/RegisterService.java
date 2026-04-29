package com.project.notes.service;

import com.project.notes.model.User;
import com.project.notes.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class RegisterService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public RegisterService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private boolean validateCredentials(String username, String password) {
        if (username == null || username.isBlank()) {
            System.out.println("Username is empty");
            return false;
        }
        if (password == null || password.isBlank()) {
            System.out.println("Password is empty");
            return false;
        }
        return true;
    }

    private boolean isAbleToRegister(String username, String password) {
        if (validateCredentials(username, password)) {
            return !userRepository.existsByUsername(username);
        }
        return false;
    }

    public User registerUser(String username, String password) {

        if (isAbleToRegister(username, password)) {
            String encryptedPassword = passwordEncoder.encode(password);

            User user = new User();
            user.setUsername(username);
            user.setPassword(encryptedPassword);
            user.setRole("USER");

            return userRepository.save(user);
        }

        return null;
    }

    public User login(String username, String password) {

        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    public void updatePassword(User user, String newPassword) {
        String updatedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(updatedPassword);
        userRepository.save(user);


    }


}
