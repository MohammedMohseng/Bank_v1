package com.example.taskmanager.DTOs;
import com.example.taskmanager.entities.Task;

public class TaskDTO {

    Task task = new Task();

    public Long id = task.getId();
    public String title = task.getTilte();
    public String description = task.getDescription();
    public boolean complted = task.getCompleted();
}
