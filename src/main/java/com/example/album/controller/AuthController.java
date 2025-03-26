package com.example.album.controller;

import com.example.album.dto.RegisterInput;
import com.example.album.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register (@ModelAttribute("username") String username,@ModelAttribute("password") String password) {
        authService.register(new RegisterInput(username,password));
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String getRegister () {
        return "register";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}
