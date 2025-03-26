package com.example.album.service.impl;

import com.example.album.dto.CreateAlbumDto;
import com.example.album.model.Artist;
import com.example.album.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import com.example.album.model.Album;
import com.example.album.repository.AlbumRepository;
import com.example.album.service.AlbumService;

import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService{
	private final AlbumRepository albumRepository;
	private final ArtistRepository artistRepository;
	
	public AlbumServiceImpl(AlbumRepository albumRepository, ArtistRepository artistRepository) {
		this.albumRepository = albumRepository;
		this.artistRepository = artistRepository;
	}

	@Override
	public boolean createNewAlbum(CreateAlbumDto input) {
		Album album = new Album();

		Optional<Artist> optionalArtist = artistRepository.findByNikName(input.getNikName());
		if(optionalArtist.isEmpty())
			return false;

		 Artist artist = optionalArtist.get();
		
		album.setName(input.getName());
		album.setPrice(input.getPrice());
		album.setArtist(artist);
		album = albumRepository.save(album);

		if(albumRepository.findById(album.getId()).isPresent()) {
			artist.addAlbum(album);
			return true;
		}

		return false;
	}
	
	
}
