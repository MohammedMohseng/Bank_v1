package com.example.taskmanager.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.taskmanager.dto.TaskDto;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repositry.TaskRepo;
import com.example.taskmanager.types.*;

@Service
public class TaskService {

    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public TaskDto createTask(TaskDto dto) {
        Task taskNew = new Task();

        taskNew.setTitle(dto.getTitle());
        taskNew.setDescription(dto.getDescription());
        taskNew.setCompleted(false);
        taskNew.setCreatedAt(LocalDateTime.now());

        taskRepo.save(taskNew);
        return ToDto(taskNew);
    }

    public TaskDto completed(Long id) throws RuntimeException {
        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No task Found "));
        task.setCompleted(true);
        taskRepo.save(task);
        return ToDto(task);
    }

    public List<TaskDto> geTaskDtos() {
        return taskRepo.findAll()
                .stream()
                .map(this::ToDto)
                .collect(Collectors.toList());
    }

    public TaskDto updateTask(Long id, TaskDto dto) throws RuntimeException {
        Task taskToUpdate = taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No task Found "));

        taskToUpdate.setTitle(dto.getTitle());
        taskToUpdate.setDescription(dto.getDescription());
        taskToUpdate.setCompleted(dto.getCompleted());

        // saving the updated task with the new values of DTO
        taskRepo.save(taskToUpdate);

        TaskDto updatedTask = ToDto(taskToUpdate);
        return updatedTask;
    }

    public Message deleteTask(Long id) {
        taskRepo.deleteById(id);
        Message message = new Message(Types.Code.ok, "The Task " + id + " is deleted successfully");
        return message;
    }

    private Task ToEntity(TaskDto dto) {
        Task task = new Task();

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.getCompleted());

        return task;
    }

    private TaskDto ToDto(Task task) {
        TaskDto Dto = new TaskDto();

        Dto.setId(task.getId());
        Dto.setTitle(task.getTitle());
        Dto.setComplted(task.getCompleted());
        Dto.setDescription(task.getDescription());

        return Dto;
    }
}