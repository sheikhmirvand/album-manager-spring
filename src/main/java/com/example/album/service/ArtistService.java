package com.example.album.service;

import java.util.List;

import com.example.album.dto.ArtistDto;
import com.example.album.dto.CreateArtistInput;
import com.example.album.exception.ArtistNotFoundException;

public interface ArtistService {
    boolean createArtist (CreateArtistInput input);
    ArtistDto createArtistAndReturn(CreateArtistInput input);
    List<ArtistDto> getAllArtist();
    ArtistDto getArtistById(Long id) throws ArtistNotFoundException;
}
