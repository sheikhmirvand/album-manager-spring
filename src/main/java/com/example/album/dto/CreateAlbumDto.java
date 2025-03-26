package com.example.album.dto;

public class CreateAlbumDto {
    private String name;
    private double price;
    private String nikName;

    public CreateAlbumDto() {
    }

    public CreateAlbumDto(String name, double price, String nikName) {
        this.name = name;
        this.price = price;
        this.nikName = nikName;
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
}
