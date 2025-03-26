package com.example.album.dto;

import com.example.album.model.Role;
import com.example.album.model.User;

public class RegisterInput {
    private String username;
    private String password;

    public RegisterInput() {
    }

    public RegisterInput(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(Role.ROLE_USER);
        return user;
    }
}
