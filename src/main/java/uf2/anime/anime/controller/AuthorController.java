package uf2.anime.anime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uf2.anime.anime.domain.dto.ResponseList;
import uf2.anime.anime.domain.model.Author;
import uf2.anime.anime.domain.model.projection.ProjectionAuthor;
import uf2.anime.anime.domain.model.projection.ProjectionAuthorMin;
import uf2.anime.anime.repository.AuthorRepository;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/")
    public ResponseEntity<?> findAllAutors(){
        return ResponseEntity.ok().body(new ResponseList(authorRepository.findBy(ProjectionAuthor.class)));
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<?> findBy(){
        return ResponseEntity.ok().body(new ResponseList(authorRepository.findBy(ProjectionAuthorMin.class)));
    }*/

    /*@PostMapping("/")
    public Author createAuthor(@RequestBody Author author){
        return authorRepository.save(author);
    }*/
    @PostMapping("/")
    public Author createAuthor(@RequestBody Author author){
        return authorRepository.save(author);
    }
}
