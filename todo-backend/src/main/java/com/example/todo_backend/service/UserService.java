package com.example.todo_backend.service;

import com.example.todo_backend.entity.UserEntity;
import com.example.todo_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getLoginUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }
}
