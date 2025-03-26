package com.example.album.model;

import com.example.album.dto.AlbumDto;

import jakarta.persistence.*;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    @OneToOne
    @JoinColumn(name = "music_id")
    private Music sampleMusic;
    @ManyToOne
    private Artist artist;
    public Album() {
    }

    public Album(Long id, String name, double price, Music sampleMusic) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sampleMusic = sampleMusic;
    }

    public Long getId() {
        return id;
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