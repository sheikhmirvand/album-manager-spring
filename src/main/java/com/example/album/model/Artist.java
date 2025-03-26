package com.example.album.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import com.example.album.dto.ArtistDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "nik_name")
    private String nikName;

    @OneToMany(mappedBy = "artist",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Album> albums = new ArrayList<>();

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Artist() {
    }

    public Artist(String firstName, String lastName, String nikName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nikName = nikName;
    }

    public void addAlbum (Album album) {
        albums.add(album);
    }

    public Artist(Long id, String firstName, String lastName, String nikName, LocalDateTime createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nikName = nikName;
        this.createdAt = createdAt;
    }
    
    public ArtistDto getArtistDto () {
    	ArtistDto artistDto = new ArtistDto();
    	artistDto.setId(id);
    	artistDto.setAlbums(albums);
    	artistDto.setFirstName(firstName);
    	artistDto.setLastName(lastName);
    	artistDto.setNikName(nikName);
    	artistDto.setCreatedAt(createdAt);
    	return artistDto;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNikName() {
        return nikName;
    }

    public void setNikName(String nikName) {
        this.nikName = nikName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
