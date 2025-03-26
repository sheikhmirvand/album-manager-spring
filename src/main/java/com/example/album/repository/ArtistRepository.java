package com.example.album.repository;

import com.example.album.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@ResponseBody
public interface ArtistRepository extends JpaRepository<Artist,Long> {
    Optional<Artist> findByNikName(String nikName);
}
