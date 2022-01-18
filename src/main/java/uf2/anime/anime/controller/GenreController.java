package uf2.anime.anime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uf2.anime.anime.domain.dto.ResponseList;
import uf2.anime.anime.domain.model.projection.*;
import uf2.anime.anime.repository.GenreRepository;

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
    public ResponseEntity<?> findBy(){
        return ResponseEntity.ok().body(new ResponseList(genreRepository.findBy(ProjectionGenreId.class)));
    }

}
