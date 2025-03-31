package com.example.album.controller;

import com.example.album.dto.CreateAlbumDto;
import com.example.album.dto.CreateArtistInput;
import com.example.album.dto.CreateMusicInput;
import com.example.album.service.AlbumService;
import com.example.album.service.ArtistService;
import com.example.album.service.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ArtistService artistService;

    private final AlbumService albumService;

    private final MusicService musicService;

    public AdminController(ArtistService artistService, AlbumService albumService, MusicService musicService){
        this.artistService = artistService;
        this.albumService = albumService;
        this.musicService = musicService;
    }

    @GetMapping("/create-artist")
    public String getCreateArtistPage (Model model) {
        model.addAttribute("artist",new CreateArtistInput());
        return "createArtist";
    }

    @PostMapping("/create-artist")
    public String createArtist (@ModelAttribute("artist") CreateArtistInput artistInput) {
       Boolean isArtistCreated =  artistService.createArtist(artistInput);
       System.out.println(isArtistCreated);
       if(isArtistCreated)
            return "redirect:/artists";
       return "/create-artist?error=true";
    }
    
    @GetMapping("/create-album")
    public String showCreateAlbumPage (Model model) {
        model.addAttribute("inputAlbum",new CreateAlbumDto());
        return "createAlbum";
    }

    @PostMapping("/create-album")
    public String createArtist (@ModelAttribute("inputAlbum") CreateAlbumDto inputAlbum) throws Exception {
        boolean newAlbum = albumService.createNewAlbum(inputAlbum);
        if(newAlbum) {
            return "redirect:/admin/upload-music";
        }

        return "redirect:/admin/create-artist?error=true";
    }

    @GetMapping("/upload-music")
    public String showUploadPage () {
        return "upload";
    }

    @PostMapping("/upload-music")
    public String uploadMusic (
            @RequestParam("music") MultipartFile file
            ,@RequestParam("artistId") String id
            ,@RequestParam("name") String name
    ) throws IOException {
        CreateMusicInput input = new CreateMusicInput(name,Long.parseLong(id),file);
        musicService.uploadMusic(input);

        return "salam";
    }
}
