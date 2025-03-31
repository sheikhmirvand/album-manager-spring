package com.example.album.service;

import com.example.album.dto.AlbumDto;
import com.example.album.dto.CreateAlbumDto;
import com.example.album.exception.AlbumNotFoundException;

import java.io.IOException;
import java.util.List;

public interface AlbumService {
	boolean createNewAlbum(CreateAlbumDto inputAlbum) throws IOException;
	List<AlbumDto> getAllAlbum();
	AlbumDto getById(Long id) throws AlbumNotFoundException;
}
