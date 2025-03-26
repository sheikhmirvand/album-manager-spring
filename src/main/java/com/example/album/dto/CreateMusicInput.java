package com.example.album.dto;

import org.springframework.web.multipart.MultipartFile;

public class CreateMusicInput {
    private String name;
    private Long albumId;
    private MultipartFile file;

    public CreateMusicInput() {
    }

    public CreateMusicInput(String name, Long albumId, MultipartFile file) {
        this.name = name;
        this.albumId = albumId;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
