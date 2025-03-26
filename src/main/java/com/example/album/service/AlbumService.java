package com.example.album.service;

import com.example.album.dto.AlbumDto;
import com.example.album.dto.CreateAlbumDto;

public interface AlbumService {
	boolean createNewAlbum(CreateAlbumDto inputAlbum);
}
