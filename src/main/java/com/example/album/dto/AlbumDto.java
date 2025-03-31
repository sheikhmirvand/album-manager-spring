package com.example.album.dto;

import com.example.album.model.Artist;
import com.example.album.model.Music;

import java.time.LocalDateTime;

public class AlbumDto {
	private Long id;
    private String name;
    private double price;
    private Music sampleMusic;
    private Artist artist;
    private LocalDateTime createdAt;
    private String cover;

	public AlbumDto() {
	}

	public AlbumDto(Long id, String name, double price, Music sampleMusic, Artist artist, LocalDateTime createdAt, String cover) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.sampleMusic = sampleMusic;
		this.artist = artist;
		this.createdAt = createdAt;
		this.cover = cover;
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

	public void setPrice(double price) {
		this.price = price;
	}

	public Music getSampleMusic() {
		return sampleMusic;
	}

	public void setSampleMusic(Music sampleMusic) {
		this.sampleMusic = sampleMusic;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}
}
