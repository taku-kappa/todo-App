package com.example.todo_backend.dto;

import java.time.LocalDate;

public class TodoResponseDto {

    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Long statusId;
    private String statusName;

    public Long getId() {
        return id;
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

    public Long getStatusId() {
        return statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}