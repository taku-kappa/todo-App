package com.example.todo_backend.service;

import com.example.todo_backend.dto.TodoCreateRequestDto;
import com.example.todo_backend.dto.TodoResponseDto;
import com.example.todo_backend.dto.TodoUpdateRequestDto;
import com.example.todo_backend.entity.TodoEntity;
import com.example.todo_backend.entity.TodoStatusEntity;
import com.example.todo_backend.repository.TodoRepository;
import com.example.todo_backend.repository.TodoStatusRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoStatusRepository todoStatusRepository;

    public TodoService(
            TodoRepository todoRepository,
            TodoStatusRepository todoStatusRepository
    ) {
        this.todoRepository = todoRepository;
        this.todoStatusRepository = todoStatusRepository;
    }

    // Todo一覧取得
    public List<TodoResponseDto> getTodos(Long userId) {
        List<TodoEntity> list = todoRepository.findByUserId(userId);
        List<TodoResponseDto> todos = new ArrayList<>();
        for (TodoEntity todo : list) {
            todos.add(toResponseDto(todo));
        }

        return todos;

//        return todoRepository.findByUserId(userId)
//                .stream()
//                .map(this::toResponseDto)
//                .collect(Collectors.toList());
    }

    // Todo作成
    public void createTodo(Long userId, TodoCreateRequestDto dto) {
        todoStatusRepository.findById(dto.getStatusId())
                .orElseThrow(() -> new RuntimeException("Status not found"));

        TodoEntity todo = new TodoEntity();
        todo.setUserId(userId);
        todo.setStatusId(dto.getStatusId());
        todo.setTitle(dto.getTitle());
        todo.setDescription(dto.getDescription());
        todo.setDueDate(dto.getDueDate());

        todoRepository.save(todo);
    }

    // Todo更新（所有者チェック）
    public void updateTodo(Long userId, Long id, TodoUpdateRequestDto dto) {
        TodoEntity todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        if (!todo.getUserId().equals(userId)) {
            throw new RuntimeException("Forbidden");
        }

        if (dto.getStatusId() != null) {
            todoStatusRepository.findById(dto.getStatusId())
                    .orElseThrow(() -> new RuntimeException("Status not found"));
            todo.setStatusId(dto.getStatusId());
        }

        if (dto.getTitle() != null) {
            todo.setTitle(dto.getTitle());
        }

        if (dto.getDescription() != null) {
            todo.setDescription(dto.getDescription());
        }

        if (dto.getDueDate() != null) {
            todo.setDueDate(dto.getDueDate());
        }

        todoRepository.save(todo);
    }

    // Todo削除（所有者チェック）
    public void deleteTodo(Long userId, Long id) {
        TodoEntity todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        if (!todo.getUserId().equals(userId)) {
            throw new RuntimeException("Forbidden");
        }

        todoRepository.delete(todo);
    }

    // Entity → DTO
    private TodoResponseDto toResponseDto(TodoEntity todo) {
        TodoStatusEntity status = todoStatusRepository.findById(todo.getStatusId())
                .orElseThrow(() -> new RuntimeException("Status not found"));

        TodoResponseDto dto = new TodoResponseDto();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        dto.setDescription(todo.getDescription());
        dto.setDueDate(todo.getDueDate());
        dto.setStatusId(status.getId());
        dto.setStatusName(status.getName());
        return dto;
    }
}
