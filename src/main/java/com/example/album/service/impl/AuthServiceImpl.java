package com.example.album.service.impl;

import com.example.album.dto.RegisterInput;
import com.example.album.model.User;
import com.example.album.repository.UserRepository;
import com.example.album.service.AuthService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(RegisterInput input) {
        User user = input.toUser();
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        userRepository.save(user);
    }
}
