package com.example.album.repository;

import com.example.album.model.Album;
import com.example.album.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MusicRepository extends JpaRepository<Music,Long> {
    Optional<Album> findByAlbum(Album album);
}
