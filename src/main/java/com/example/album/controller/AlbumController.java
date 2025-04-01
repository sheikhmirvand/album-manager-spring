package com.example.album.controller;

import com.example.album.dto.AlbumDto;
import com.example.album.exception.AlbumNotFoundException;
import com.example.album.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/album")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public String getAllAlbum(Model model) {
        List<AlbumDto> allAlbum = albumService.getAllAlbum();
        System.out.println(allAlbum.get(0).getArtist().getFirstName());
        model.addAttribute("albums",allAlbum);
        return "albumList";
    }

    @GetMapping("/{id}")
    public String getAlbumPage(@PathVariable Long id,Model model) throws AlbumNotFoundException {
        AlbumDto albumDto = albumService.getById(id);
        model.addAttribute("album",albumDto);
        return "album";
    }
}
