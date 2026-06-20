package com.example.taskmanager.service;

import com.example.taskmanager.dto.UserDto;
import com.example.taskmanager.entity.User;
import com.example.taskmanager.repositry.UserRepo;

public class UserService {
    private final UserRepo UserRepo;

    public UserService(UserRepo UserRepo) {
        this.UserRepo = UserRepo;
    }

    // private String generateJwt() {
    //     return "";
    // }

    // private User toEntity(UserDto dto) {
    //     User User = new User(dto.getUserName(),dto.getPassword());
    //     return User;
    // }
}
