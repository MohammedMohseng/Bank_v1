package com.example.taskmanager.entities;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public String getTilte() {
        return this.title;
    }

    public String getDescription() {
        return description;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
