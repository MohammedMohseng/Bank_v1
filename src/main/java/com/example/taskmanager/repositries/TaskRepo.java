package com.example.taskmanager.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.taskmanager.entities.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task , Long> {

    
}
