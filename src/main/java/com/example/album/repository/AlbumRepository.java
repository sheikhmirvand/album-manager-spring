package com.example.album.repository;

import com.example.album.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaAuditing
public interface AlbumRepository extends JpaRepository<Album,Long> {
}
