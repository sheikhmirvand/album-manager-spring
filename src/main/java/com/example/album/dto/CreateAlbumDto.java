package com.example.album.dto;

import org.springframework.web.multipart.MultipartFile;

public class CreateAlbumDto {
    private String name;
    private double price;
    private String nikName;
    private MultipartFile file;

    public CreateAlbumDto() {
    }

    public CreateAlbumDto(String name, double price, String nikName, MultipartFile file) {
        this.name = name;
        this.price = price;
        this.nikName = nikName;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNikName() {
        return nikName;
    }

    public void setNikName(String nikName) {
        this.nikName = nikName;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
