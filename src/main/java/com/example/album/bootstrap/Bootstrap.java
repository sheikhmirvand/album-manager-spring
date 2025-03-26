package com.example.album.bootstrap;

import com.example.album.model.Role;
import com.example.album.model.User;
import com.example.album.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class Bootstrap implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Bootstrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.findByUsername("admin").isEmpty()){
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("12345678"));
            if(Files.exists(Paths.get("/home/ali/Desktop/show/album/src/main/resources/upload"))){
                Files.createDirectories(Path.of("/home/ali/Desktop/show/album/src/main/resources/upload"));
            }
            admin.setRole(Role.ROLE_ADMIN);
            userRepository.save(admin);
        }
    }
}
