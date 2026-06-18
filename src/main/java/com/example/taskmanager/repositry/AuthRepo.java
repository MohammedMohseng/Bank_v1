package com.example.taskmanager.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.taskmanager.entity.Auth;

public interface AuthRepo extends JpaRepository<Auth, Long> {
}

