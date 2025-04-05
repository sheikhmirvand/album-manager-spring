package com.example.album.controller;

import com.example.album.dto.RegisterInput;
import com.example.album.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
    public String register (@Valid @ModelAttribute RegisterInput input, Errors errors,Model model) {
        System.out.println(errors.hasErrors());
        if(errors.hasErrors()) {
            model.addAttribute("errors",errors.getAllErrors());
            return "register";
        }
        authService.register(new RegisterInput(input.getUsername(),input.getPassword()));
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String getRegister (Model model) {
        model.addAttribute("registerInput",new RegisterInput());
        return "register";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}
