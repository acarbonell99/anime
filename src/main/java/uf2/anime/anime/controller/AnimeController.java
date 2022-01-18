package uf2.anime.anime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uf2.anime.anime.domain.dto.ResponseList;
import uf2.anime.anime.domain.model.Anime;
import uf2.anime.anime.domain.model.projection.ProjectionAnime;
import uf2.anime.anime.repository.AnimeRepository;

import java.util.UUID;

@RestController
@RequestMapping("/anime")
public class AnimeController {

    @Autowired
    private AnimeRepository animeRepository;

    @GetMapping("/")
    public ResponseEntity<?> findAllAnimes(){
        return ResponseEntity.ok().body(new ResponseList(animeRepository.findBy(ProjectionAnime.class)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findBy(){
        return ResponseEntity.ok().body(new ResponseList(animeRepository.findBy(ProjectionAnime.class)));
    }
    /*public Object getAnime(@PathVariable UUID id){
        Anime anime = animeRepository.findBy(id).orElse(null);
        if(anime == null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(anime);
    }*/

    @PostMapping("/")
    public Anime createAnime(@RequestBody Anime anime){
        return animeRepository.save(anime);
    }
}