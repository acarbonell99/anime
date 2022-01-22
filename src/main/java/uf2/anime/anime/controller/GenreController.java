package uf2.anime.anime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uf2.anime.anime.domain.dto.Error;
import uf2.anime.anime.domain.dto.ResponseList;
import uf2.anime.anime.domain.model.Anime;
import uf2.anime.anime.domain.model.Author;
import uf2.anime.anime.domain.model.Genre;
import uf2.anime.anime.domain.model.projection.*;
import uf2.anime.anime.repository.GenreRepository;

import java.util.UUID;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/")
    public ResponseEntity<?> findAllGenre(){
        return ResponseEntity.ok().body(genreRepository.findBy(ProjectionGenre.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findBy(@PathVariable UUID id){
        Genre genre = genreRepository.findById(id).orElse(null);
        if(genre == null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(Error.message("Nos'ha trobat el genre amb id= " + id));
        }
        return ResponseEntity.ok().body(genreRepository.findByGenreid(id, ProjectionGenreWithAnime.class));
    }

    @PostMapping("/")
    public Genre creategenre(@RequestBody Genre genre){
        return genreRepository.save(genre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delGenre(@PathVariable UUID id){
        Genre genre = genreRepository.findById(id).orElse(null);
        if(genre == null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(Error.message("Nos'ha trobat el genre amb id= " + id));
        }
        genreRepository.delete(genre);
        return ResponseEntity.ok().build();
    }
}