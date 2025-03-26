package com.example.album.service;

import com.example.album.dto.CreateMusicInput;

import java.io.IOException;

public interface MusicService {
    boolean uploadMusic (CreateMusicInput input)  throws IOException;
}
