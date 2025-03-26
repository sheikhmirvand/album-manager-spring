package com.example.album.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class HomeController {
    @GetMapping
    public String getHomePage () {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return "index";
    }
}
