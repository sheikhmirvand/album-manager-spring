package com.example.album.service.impl;

import com.example.album.dto.CreateArtistInput;
import com.example.album.repository.ArtistRepository;
import com.example.album.service.ArtistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArtistServiceImplTest {
    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ArtistService artistService;

    @BeforeEach
    void setUp() {
        artistRepository.deleteAll();
    }

    @Test
    public void successSaveUserTest() {
        CreateArtistInput createArtistInput =
                new CreateArtistInput("test","test","test");
        boolean result = artistService.createArtist(createArtistInput);

        assertEquals(true,result);
    }
}