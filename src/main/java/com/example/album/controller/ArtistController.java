package com.example.album.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.album.dto.ArtistDto;
import com.example.album.exception.ArtistNotFoundException;
import com.example.album.service.ArtistService;


@Controller
public class ArtistController {
	final private ArtistService artistService;
	
	public ArtistController (ArtistService artistService) {
		this.artistService = artistService;
	}
	
	
	@GetMapping("/artist")
	public String getArtistsPage (Model model) {
		List<ArtistDto> artists = artistService.getAllArtist();
		model.addAttribute("artists",artists);

		return "artistList";
	}

  @GetMapping("/artist/{id}")
  public String getArtistPage (Model model,@PathVariable Long id) throws ArtistNotFoundException {
    ArtistDto artist = artistService.getArtistById(id);
    model.addAttribute("artist",artist);
    return "artist";
  }
}
