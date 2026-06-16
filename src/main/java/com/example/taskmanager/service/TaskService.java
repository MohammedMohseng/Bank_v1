package com.example.taskmanager.service;

import org.springframework.stereotype.Service;

import com.example.taskmanager.dto.TaskDto;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repositry.TaskRepo;

@Service
public class TaskService {

    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public TaskDto createTask(TaskDto Dto) {
        Task taskNew = ToEntity(Dto);
        Task savedTask;
        savedTask = taskRepo.save(taskNew);
        return ToDto(savedTask);
    }

    public String completed(Task task) throws RuntimeException {
        Task taskCompleted = taskRepo.findById(task.getId())
                .orElseThrow(() -> new RuntimeException("No task Found "));
        taskCompleted.setCompleted(true);
        taskRepo.save(taskCompleted);
        return "completed";
    }

    public TaskDto updateTask(Task task) throws RuntimeException {
        Task taskToUpdate = taskRepo.findById(task.getId())
                .orElseThrow(() -> new RuntimeException("No task Found "));

        taskToUpdate.setTitle(task.getTitle());
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setCompleted(task.getCompleted());

        // saving the updated task with the new values of DTO
        taskRepo.save(taskToUpdate);

        TaskDto updatedTask = ToDto(taskToUpdate);
        return updatedTask;
    }

    public String deleteTask(Task task) {
        taskRepo.deleteById(task.getId());
        return "the operation is completed";
    }

    private Task ToEntity(TaskDto Dto) {
        Task task = new Task();

        task.setTitle(Dto.getTitle());
        task.setDescription(Dto.getDescription());
        task.setCompleted(Dto.getCompleted());

        return task;
    }

    private TaskDto ToDto(Task task) {
        TaskDto Dto = new TaskDto();

        Dto.setTitle(task.getTitle());
        Dto.setComplted(task.getCompleted());
        Dto.setDescription(task.getDescription());

        return Dto;
    }
}