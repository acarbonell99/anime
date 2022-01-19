package uf2.anime.anime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import uf2.anime.anime.domain.dto.Error;
import uf2.anime.anime.domain.dto.ResponseList;
import uf2.anime.anime.domain.model.Anime;
import uf2.anime.anime.domain.model.Author;
import uf2.anime.anime.domain.model.projection.ProjectionAuthor;
import uf2.anime.anime.repository.AuthorRepository;

import java.util.UUID;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    /*@GetMapping("/")
    public ResponseEntity<?> findAllAutors(){
        return ResponseEntity.ok().body(new ResponseList(authorRepository.findBy(ProjectionAuthor.class)));
    }*/
    @GetMapping("/")
    public ResponseEntity<?> findAllAuthor(Authentication authentication) {
        return ResponseEntity.ok().body(new ResponseList(authorRepository.findBy(ProjectionAuthor.class)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findBy(@PathVariable UUID id){
        Author author = authorRepository.findById(id).orElse(null);
        if(author == null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(Error.message("Nos'ha trobat l'author amb id= " + id));
        }
        authorRepository.save(author);
        return ResponseEntity.ok().body(author);
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
