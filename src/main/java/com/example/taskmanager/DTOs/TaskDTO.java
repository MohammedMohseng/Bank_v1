package com.example.taskmanager.DTOs;

import com.example.taskmanager.entities.Task;

public class TaskDTO {

    Task task = new Task();
    public Long id;
    public String title;
    public String description;
    public boolean completed;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setComplted(boolean completed) {
        this.completed = completed;
    }
}
