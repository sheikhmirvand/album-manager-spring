package com.example.album.model;

import com.example.album.dto.AlbumDto;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private String cover;

    @OneToOne
    @JoinColumn(name = "music_id")
    private Music sampleMusic;

    @ManyToOne
    private Artist artist;

    @CreatedDate
    private LocalDateTime getCreatedAt = LocalDateTime.now();

    public Album() {
    }

    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

    public Album(Long id, String name, double price, Music sampleMusic,LocalDateTime createdAt,String cover) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sampleMusic = sampleMusic;
        this.createdAt = createdAt;
        this.cover = cover;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getGetCreatedAt() {
        return getCreatedAt;
    }


    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setGetCreatedAt(LocalDateTime getCreatedAt) {
        this.getCreatedAt = getCreatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setId(Long id) {
        this.id = id;
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

    public AlbumDto getAlbumDto () {
    	AlbumDto albumDto = new AlbumDto();
    	albumDto.setId(id);
    	albumDto.setArtist(artist);
    	albumDto.setName(name);
    	albumDto.setPrice(price);
    	albumDto.setSampleMusic(sampleMusic);
    	albumDto.setCreatedAt(createdAt);
    	albumDto.setCover(cover);
    	return albumDto;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Music getSampleMusic() {
        return sampleMusic;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setSampleMusic(Music sampleMusic) {
        this.sampleMusic = sampleMusic;
    }
}