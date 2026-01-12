package com.example.todo_backend.repository;

import com.example.todo_backend.entity.TodoStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoStatusRepository extends JpaRepository<TodoStatusEntity, Long> {
}
