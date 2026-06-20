package com.example.taskmanager.entity;

import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import com.example.taskmanager.types.Types.Gender;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;
    private String role;

    // ========= the consteructure =============

    public User(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    // ========== Getters / Setters ==============

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // ================ sescurity ================

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername(){
        return this.userName;
    }

    @Override
    public String getPassword(){
        return this.password;
    } 

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override 
    public boolean isAccountNonLocked(){
        return true;

    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override 
    public boolean isEnabled(){
        return true;
    }
}
