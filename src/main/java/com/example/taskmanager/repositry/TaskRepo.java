package com.example.taskmanager.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.taskmanager.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {
}
