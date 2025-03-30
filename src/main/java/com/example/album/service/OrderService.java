package com.example.album.service;

import com.example.album.exception.AlbumNotFoundException;
import com.example.album.model.Album;

public interface OrderService {
    void addAlbumToOrder(Long albumId) throws AlbumNotFoundException;
}
