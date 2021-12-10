package uf2.anime.anime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uf2.anime.anime.domain.dto.ResponseList;
import uf2.anime.anime.domain.model.projection.ProjectionAuthor;
import uf2.anime.anime.domain.model.projection.ProjectionAuthorMin;
import uf2.anime.anime.repository.AuthorRepository;

@RestController
@RequestMapping("/anime")
public class AuthorController {

    @Autowired
    private AuthorRepository autorRepository;

    @GetMapping("/")
    public ResponseEntity<?> findAllAutors(){
        return ResponseEntity.ok().body(new ResponseList(autorRepository.findBy(ProjectionAuthor.class)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findBy(){
        return ResponseEntity.ok().body(new ResponseList(autorRepository.findBy(ProjectionAuthorMin.class)));
    }
}
