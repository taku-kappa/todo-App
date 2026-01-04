package com.example.todo_backend.service;

import com.example.todo_backend.entity.UserEntity;
import com.example.todo_backend.repository.UserRepository;
import com.example.todo_backend.util.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String login(String email, String name) {

        UserEntity user = userRepository
                .findByEmailAndName(email, name)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return JwtUtil.generateToken(user.getId());
    }
}
