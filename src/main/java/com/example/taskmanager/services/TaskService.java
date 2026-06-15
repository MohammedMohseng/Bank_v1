package com.example.taskmanager.services;

import org.springframework.stereotype.Service;

import com.example.taskmanager.DTOs.TaskDTO;
import com.example.taskmanager.entities.Task;
import com.example.taskmanager.repositries.TaskRepo;

@Service
public class TaskService {

    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public TaskDTO createTask(TaskDTO DTO) {
        Task taskNew = ToEntity(DTO);
        Task savedTask = taskNew;

        return ToDTO(savedTask);
    }

    private Task ToEntity(TaskDTO DTO) {
        Task task = new Task();

        task.setTitle(DTO.getTitle());
        task.setDescription(DTO.getDescription());
        task.setCompleted(DTO.getCompleted());

        return task;
    }

    private TaskDTO ToDTO(Task task) {
        TaskDTO DTO = new TaskDTO();

        DTO.setTitle(task.getTitle());
        DTO.setComplted(task.getCompleted());
        DTO.setDescription(task.getDescription());

        return DTO;
    }
}