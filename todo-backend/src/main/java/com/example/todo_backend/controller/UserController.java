package com.example.todo_backend.controller;

import com.example.todo_backend.entity.UserEntity;
import com.example.todo_backend.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public UserEntity getMe(HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        return userService.getLoginUser(userId);
    }

    /* ユーザー登録
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.save(user);
    }
    */
}

