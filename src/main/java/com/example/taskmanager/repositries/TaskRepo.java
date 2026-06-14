package com.example.taskmanager.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.taskmanager.entities.Task;

public interface TaskRepo extends JpaRepository<Task , Long> {


}