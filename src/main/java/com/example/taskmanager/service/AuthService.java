package com.example.taskmanager.service;

import com.example.taskmanager.dto.AuthDto;
import com.example.taskmanager.entity.Auth;

import com.example.taskmanager.repositry.*;

public class AuthService {
    private final AuthRepo AuthRepo;

    public AuthService(AuthRepo AuthRepo) {
        this.AuthRepo = AuthRepo;
    }


    

    private String generateJwt() {
        return "";
    }

    private Auth toEntity(AuthDto dto) {
        Auth auth = new Auth();
        auth.setUserName(dto.getUserName());
        auth.setPassword(dto.getPassword());

        return auth;
    }

    private AuthDto toDto(Auth auth) {
        AuthDto dto = new AuthDto();

        dto.setId(auth.getId());
        dto.setUserName(auth.getUserName());
        dto.setPassword(auth.getPassword());

        return dto;
    }
}
