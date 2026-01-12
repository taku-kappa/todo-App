package com.example.todo_backend.controller;

import com.example.todo_backend.dto.TodoCreateRequestDto;
import com.example.todo_backend.dto.TodoResponseDto;
import com.example.todo_backend.dto.TodoUpdateRequestDto;
import com.example.todo_backend.service.TodoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:8080")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // 一覧取得
    @GetMapping
    public List<TodoResponseDto> getTodos(HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        return todoService.getTodos(userId);
    }

    // 作成
    @PostMapping
    public void createTodo(
            HttpServletRequest request,
            @RequestBody TodoCreateRequestDto dto
    ) {
        Long userId = (Long) request.getAttribute("userId");
        todoService.createTodo(userId, dto);
    }

    // 更新
    @PutMapping("/{id}")
    public void updateTodo(
            HttpServletRequest request,
            @PathVariable Long id,
            @RequestBody TodoUpdateRequestDto dto
    ) {
        Long userId = (Long) request.getAttribute("userId");
        todoService.updateTodo(userId, id, dto);
    }

    // 削除
    @DeleteMapping("/{id}")
    public void deleteTodo(
            HttpServletRequest request,
            @PathVariable Long id
    ) {
        Long userId = (Long) request.getAttribute("userId");
        todoService.deleteTodo(userId, id);
    }
}
