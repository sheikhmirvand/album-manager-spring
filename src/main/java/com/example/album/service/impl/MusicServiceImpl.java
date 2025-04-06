package com.example.album.service.impl;

import com.example.album.dto.CreateMusicInput;
import com.example.album.model.Album;
import com.example.album.model.Music;
import com.example.album.repository.AlbumRepository;
import com.example.album.repository.MusicRepository;
import com.example.album.service.MusicService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService {

    public final static String UPLOAD_PATH = "/home/ali/Desktop/show/album/upload/music/";

    private final AlbumRepository albumRepository;
    private final MusicRepository musicRepository;

    public MusicServiceImpl(AlbumRepository albumRepository, MusicRepository musicRepository) {
        this.albumRepository = albumRepository;
        this.musicRepository = musicRepository;
    }

    @Override
    public boolean uploadMusic(CreateMusicInput input) throws IOException {
        String fileName = Math.floor(Math.random() * 100) + input.getFile().getOriginalFilename();
        String filePath = UPLOAD_PATH + fileName;
        File file = new File(filePath);

        Optional<Album> optionalAlbum =albumRepository.findById(input.getAlbumId());
        if(optionalAlbum.isEmpty()){
            return false;
        }
        Music music = new Music();
        music.setName(input.getName());
        music.setAlbum(optionalAlbum.get());
        music.setFileName(fileName);
        musicRepository.save(music);

        Album album = optionalAlbum.get();
        album.setSampleMusic(music);
        albumRepository.save(album);

        input.getFile().transferTo(file);
        return true;
    }
}
