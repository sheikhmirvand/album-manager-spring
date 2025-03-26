package com.example.album.service.impl;

import com.example.album.dto.ArtistDto;
import com.example.album.dto.CreateArtistInput;
import com.example.album.exception.ArtistNotFoundException;
import com.example.album.model.Artist;
import com.example.album.repository.ArtistRepository;
import com.example.album.service.ArtistService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService {
	private final ArtistRepository artistRepository;

	public ArtistServiceImpl(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}

	@Override
	public boolean createArtist(CreateArtistInput input) {
		Artist artist = input.toArtist();
		artist = artistRepository.save(artist);
		if (artistRepository.findById(artist.getId()).isPresent())
			return true;

		return false;
	}

	@Override
	public List<ArtistDto> getAllArtist() {

		return artistRepository.findAll().stream().map(Artist::getArtistDto).collect(Collectors.toList());
	}

	@Override
	public ArtistDto getArtistById(Long id) throws ArtistNotFoundException {
		Optional<Artist> optinalArtist = artistRepository.findById(id);
		if(!optinalArtist.isPresent()) {
			throw new ArtistNotFoundException("artist not found");
		}
		return optinalArtist.get().getArtistDto();
	}
}
