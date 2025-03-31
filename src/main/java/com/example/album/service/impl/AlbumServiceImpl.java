package com.example.album.service.impl;

import com.example.album.dto.AlbumDto;
import com.example.album.dto.CreateAlbumDto;
import com.example.album.exception.AlbumNotFoundException;
import com.example.album.model.Album;
import com.example.album.model.Artist;
import com.example.album.repository.AlbumRepository;
import com.example.album.repository.ArtistRepository;
import com.example.album.service.AlbumService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    public final static String UPLOAD_PATH = "/home/ali/Desktop/show/album/src/main/resources/upload/cover/";
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;


    public AlbumServiceImpl(AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public boolean createNewAlbum(CreateAlbumDto input) throws IOException {
        Album album = new Album();

        Optional<Artist> optionalArtist = artistRepository.findByNikName(input.getNikName());
        if (optionalArtist.isEmpty())
            return false;

        Artist artist = optionalArtist.get();

        String savedFileName = UPLOAD_PATH
                + Math.floor(Math.random() * 100)
                + input.getFile().getOriginalFilename();

		File file = new File(savedFileName);
		input.getFile().transferTo(file);


        album.setName(input.getName());
        album.setPrice(input.getPrice());
        album.setCover(savedFileName);
        album.setArtist(artist);
        album = albumRepository.save(album);

        if (albumRepository.findById(album.getId()).isPresent()) {
            artist.addAlbum(album);
            return true;
        }

        return false;
    }

    @Override
    public List<AlbumDto> getAllAlbum() {
        return albumRepository.findAll()
                .stream().map(Album::getAlbumDto).collect(Collectors.toList());
    }

    @Override
    public AlbumDto getById(Long id) throws AlbumNotFoundException {
        return albumRepository
                .findById(id)
                .orElseThrow(() -> new AlbumNotFoundException("album not found"))
                .getAlbumDto();
    }
}
