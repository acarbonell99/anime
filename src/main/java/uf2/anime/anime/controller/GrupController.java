package uf2.anime.anime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uf2.anime.anime.domain.dto.Error;
import uf2.anime.anime.domain.dto.ResponseMessage;
import uf2.anime.anime.domain.model.Grup;
import uf2.anime.anime.domain.model.projection.ProjectionGrup;
import uf2.anime.anime.repository.GrupRepository;

import java.util.UUID;

@RestController
@RequestMapping("/grup")
public class GrupController {
    @Autowired
    private GrupRepository grupRepository;

    @GetMapping("/")
    public ResponseEntity<?> findAllGrup(){
        return ResponseEntity.ok().body(grupRepository.findBy(ProjectionGrup.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findBy(@PathVariable UUID id){
        Grup grup = grupRepository.findById(id).orElse(null);
        if(grup == null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(Error.message("Nos'ha trobat el grup amb id= " + id));
        }
        return ResponseEntity.ok().body(grupRepository.findByGrupid(id, ProjectionGrup.class));
    }

    @PostMapping("/")
    public Grup creategrup(@RequestBody Grup grup){
        return grupRepository.save(grup);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delGrup(@PathVariable UUID id){
        Grup grup = grupRepository.findById(id).orElse(null);
        if(grup == null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(Error.message("Nos'ha trobat el grup amb id= " + id));
        }
        grupRepository.delete(grup);
        return ResponseEntity.ok().body(ResponseMessage.message("Grup amb id: " + id + " s'ha elimminat"));
    }
}