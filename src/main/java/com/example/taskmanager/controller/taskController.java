package com.example.taskmanager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.taskmanager.dto.TaskDto;
import com.example.taskmanager.service.TaskService;
import com.example.taskmanager.types.Message;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tasks")
public class taskController {
    private final TaskService service;

    public taskController(TaskService service) {
        this.service = service;
    }

    // working ...
    @GetMapping("/")
    public List<TaskDto> myMethod() {
        return service.geTaskDtos();
    }

    // working ...
    @PostMapping("/create")
    public TaskDto createNewTask(@RequestBody TaskDto entity) {
        service.createTask(entity);
        return entity;
    }

    // Working ...
    @PutMapping("update/{id}")
    public TaskDto updateExistedTask(@PathVariable Long id, @RequestBody TaskDto entity) {
        TaskDto updatedTask = service.updateTask(id, entity);
        return updatedTask;
    }

    @PatchMapping("{id}/completed")
    public ResponseEntity completeTask(@PathVariable Long id) {
        TaskDto completed = service.completed(id);

        return ResponseEntity.ok(completed);
    }

    // working ...
    @DeleteMapping("delete/{id}")
    public Message deleteExistedTask(@PathVariable Long id) {
        Message message = service.deleteTask(id);
        return message;
    }

}
