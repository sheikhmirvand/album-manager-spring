package com.example.album.bootstrap;

import com.example.album.model.Album;
import com.example.album.model.Artist;
import com.example.album.model.Role;
import com.example.album.model.User;
import com.example.album.repository.AlbumRepository;
import com.example.album.repository.ArtistRepository;
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
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public Bootstrap(UserRepository userRepository, ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.userRepository = userRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        artistRepository.deleteAll();
        albumRepository.deleteAll();
        if(userRepository.findByUsername("admin").isEmpty()){
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("12345678"));
            if(!Files.exists(Paths.get("/home/ali/Desktop/show/album/src/main/resources/upload"))){
                Files.createDirectories(Path.of("/home/ali/Desktop/show/album/src/main/resources/upload/music"));
                Files.createDirectories(Path.of("/home/ali/Desktop/show/album/src/main/resources/upload/cover"));
            }
            admin.setRole(Role.ROLE_ADMIN);
            userRepository.save(admin);

            Artist testArtist = new Artist();
            testArtist.setFirstName("test artist");
            testArtist.setLastName("test");
            testArtist.setNikName("test nikname");

            artistRepository.save(testArtist);

            Album testAlbum = new Album();
            testAlbum.setArtist(testArtist);
            testAlbum.setName("test album");
            testAlbum.setPrice(10.0);
            albumRepository.save(testAlbum);
        }
    }
}
