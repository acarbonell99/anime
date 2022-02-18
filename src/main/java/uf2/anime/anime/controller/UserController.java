package uf2.anime.anime.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import uf2.anime.anime.domain.dto.*;
import uf2.anime.anime.domain.model.Favorite;
import uf2.anime.anime.domain.model.User;
import uf2.anime.anime.domain.model.UserFollowUser;
import uf2.anime.anime.domain.model.projection.*;
import uf2.anime.anime.repository.AnimeRepository;
import uf2.anime.anime.repository.FavoriteRepository;
import uf2.anime.anime.repository.FollowRepository;
import uf2.anime.anime.repository.UserRepository;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired private UserRepository userRepository;
    @Autowired private BCryptPasswordEncoder passwordEncoder;
    @Autowired private FavoriteRepository favoriteRepository;
    @Autowired private FollowRepository followRepository;

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(new ResponseList(userRepository.findBy(ProjectionUser.class)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable UUID id){
        return ResponseEntity.ok().body(ResponseList.list(userRepository.findByUserid(id, ProjectionUserDetail.class)));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RequestUserRegister userRegisterRequest) {
        if (userRepository.findByUsername(userRegisterRequest.username) == null) {
            User user = new User();
            user.username = userRegisterRequest.username;
            user.password = passwordEncoder.encode(userRegisterRequest.password);
            user.enabled = true;
            userRepository.save(user);
            return ResponseEntity.ok().body(ResponseMessage.message("Usuari registrat correctament"));
        }
        return ResponseEntity.ok().body(ResponseMessage.message("Error en la creació d'usuari"));
    }

    @DeleteMapping("/favorites")
    public ResponseEntity<?> delFavorite(@RequestBody RequestFavorite requestFavorite, Authentication authentication) {
        if (authentication != null) {
            User authenticatedUser = userRepository.findByUsername(authentication.getName());
            if (authenticatedUser != null) {
                Favorite favorite = new Favorite();
                favorite.animeid = requestFavorite.animeid;
                favorite.userid = authenticatedUser.userid;
                favoriteRepository.delete(favorite);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseMessage.message("No autorizado"));
    }

    @PostMapping("/favorites")
    public ResponseEntity<?> addFavorite(@RequestBody RequestFavorite requestFavorite, Authentication authentication) {
        if (authentication != null) {
            User authenticatedUser = userRepository.findByUsername(authentication.getName());
            if (authenticatedUser != null) {
                Favorite favorite = new Favorite();
                favorite.animeid = requestFavorite.animeid;
                favorite.userid = authenticatedUser.userid;
                favoriteRepository.save(favorite);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseMessage.message("No estas autorizado"));
    }

    @GetMapping("/favorites")
    public ResponseEntity<?> getFavorites(Authentication authentication) {
        if (authentication != null) {
            User authenticatedUser = userRepository.findByUsername(authentication.getName());
            if (authenticatedUser != null) {
                return ResponseEntity.ok().body(new ResponseList(userRepository.findByUsername(authentication.getName(), ProjectionAnimeImg.class)));
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseMessage.message("No autorizado"));
    }

    @PostMapping("/follow")
    public ResponseEntity<?> addFollow(@RequestBody RequestFollow requestFollow, Authentication authentication) {
        if (authentication != null) {
            User authenticatedUser = userRepository.findByUsername(authentication.getName());
            if (authenticatedUser != null) {
                UserFollowUser userFollowUser = new UserFollowUser();
                userFollowUser.userid = authenticatedUser.userid;
                userFollowUser.useridfollowed = requestFollow.useridfollowed;
                followRepository.save(userFollowUser);
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseMessage.message("No estas autorizado"));
    }

    @GetMapping("/follow")
    public ResponseEntity<?> getFollow(Authentication authentication){
        if (authentication != null) {
            User authenticatedUser = userRepository.findByUsername(authentication.getName());
            if (authenticatedUser != null){
                return ResponseEntity.ok().body(new ResponseList(userRepository.findByUsername(authentication.getName(), ProjectionUserFollowUser.class)));
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseMessage.message("No autorizado"));
    }

    @GetMapping("/grup")
    public ResponseEntity<?> getUserGrup(Authentication authentication){
        if (authentication != null) {
            User authenticatedUser = userRepository.findByUsername(authentication.getName());
            if (authenticatedUser != null){
                return ResponseEntity.ok().body(new ResponseList(userRepository.findByUsername(authentication.getName(), ProjectionGrupUser.class)));
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseMessage.message("No autorizado"));
    }
}