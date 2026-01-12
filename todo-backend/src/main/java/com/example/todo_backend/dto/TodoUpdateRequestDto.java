package com.example.todo_backend.dto;


import java.time.LocalDate;

public class TodoUpdateRequestDto {

    private String title;
    private String description;
    private LocalDate dueDate;
    private Long statusId;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Long getStatusId() {
        return statusId;
    }
}
