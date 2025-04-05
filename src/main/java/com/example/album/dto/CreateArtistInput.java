package com.example.album.dto;

import com.example.album.model.Artist;
import jakarta.validation.constraints.NotBlank;

public class CreateArtistInput {

    @NotBlank(message = "first name is required")
    private String firstName;

    @NotBlank(message = "last name is required")
    private String lastName;

    @NotBlank(message = "nik name is required")
    private String nikName;

    public CreateArtistInput() {
    }

    public Artist toArtist() {
        return new Artist(firstName,lastName,nikName);
    }

    public CreateArtistInput(String firstName, String lastName, String nikName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nikName = nikName;
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

}
