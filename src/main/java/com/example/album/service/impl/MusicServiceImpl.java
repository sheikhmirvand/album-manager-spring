package com.example.album.service.impl;

import com.example.album.dto.CreateMusicInput;
import com.example.album.service.MusicService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class MusicServiceImpl implements MusicService {

    public final static String UPLOAD_PATH = "/home/ali/Desktop/show/album/src/main/resources/upload/music/";

    @Override
    public boolean uploadMusic(CreateMusicInput input) throws IOException {
        String filePath = UPLOAD_PATH + Math.floor(Math.random() * 100) + input
                .getFile()
                .getOriginalFilename();
        File file = new File(filePath);

        input.getFile().transferTo(file);
        return true;
    }
}
