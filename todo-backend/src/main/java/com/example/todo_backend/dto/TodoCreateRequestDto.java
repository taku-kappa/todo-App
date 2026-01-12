package com.example.todo_backend.dto;

import java.time.LocalDate;

public class TodoCreateRequestDto {

    private Long statusId;
    private String title;
    private String description;
    private LocalDate dueDate;

    public Long getStatusId() {
        return statusId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
