package uf2.anime.anime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import uf2.anime.anime.domain.dto.ResponseList;
import uf2.anime.anime.domain.model.Autor;
import uf2.anime.anime.domain.model.projection.ProjectionAutor;
import uf2.anime.anime.repository.AutorRepository;

@RestController
@RequestMapping("/author")
public class AutorController {

    @Autowired
    private AutorRepository authorRepository;

    /*@GetMapping("/")
    public ResponseEntity<?> findAllAutors(){
        return ResponseEntity.ok().body(new ResponseList(authorRepository.findBy(ProjectionAuthor.class)));
    }*/
    @GetMapping("/")
    public ResponseEntity<?> findAllAuthor(Authentication authentication) {
        return ResponseEntity.ok().body(new ResponseList(authorRepository.findBy(ProjectionAutor.class)));
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
    public Autor createAuthor(@RequestBody Autor author){
        return authorRepository.save(author);
    }
}
