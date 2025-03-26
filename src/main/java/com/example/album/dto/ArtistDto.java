package com.example.album.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import com.example.album.model.Album;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

public class ArtistDto {
	  
	    private Long id;

	    private String firstName;


	    private String lastName;


	    private String nikName;

	    private List<Album> albums = new ArrayList<>();

	    private LocalDateTime createdAt;

		public ArtistDto(Long id, String firstName, String lastName, String nikName, List<Album> albums,
				LocalDateTime createdAt) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.nikName = nikName;
			this.albums = albums;
			this.createdAt = createdAt;
		}
		
		public ArtistDto () {}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
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

		public List<Album> getAlbums() {
			return albums;
		}

		public void setAlbums(List<Album> albums) {
			this.albums = albums;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		@Override
		public String toString() {
			return "ArtistDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", nikName="
					+ nikName + ", albums=" + albums + ", createdAt=" + createdAt + "]";
		}

		
}
