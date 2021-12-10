package uf2.anime.anime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uf2.anime.anime.domain.dto.ResponseList;
import uf2.anime.anime.domain.model.Anime;
import uf2.anime.anime.repository.AnimeRepository;

@RestController
@RequestMapping("/anime")
public class AnimeController {

    @Autowired
    private AnimeRepository animeRepository;

    @GetMapping("/")
    public ResponseEntity<?> findAllAnimes(){
        return ResponseEntity.ok().body(new ResponseList(animeRepository.findBy()));
    }

    @PostMapping("/")
    public Anime createAnime(@RequestBody Anime anime){
        return animeRepository.save(anime);
    }
}