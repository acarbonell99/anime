package uf2.anime.anime.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import uf2.anime.anime.domain.dto.RequestUserRegister;
import uf2.anime.anime.domain.dto.ResponseList;
import uf2.anime.anime.domain.dto.ResponseMessage;
import uf2.anime.anime.domain.model.Favorite;
import uf2.anime.anime.domain.model.User;
import uf2.anime.anime.domain.model.projection.ProjectionUser;
import uf2.anime.anime.domain.model.projection.ProjectionUserDetail;
import uf2.anime.anime.repository.AnimeRepository;
import uf2.anime.anime.repository.FavoriteRepository;
import uf2.anime.anime.repository.UserRepository;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired private UserRepository userRepository;
    @Autowired private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody RequestUserRegister userRegisterRequest) {

        if (userRepository.findByUsername(userRegisterRequest.username) == null) {
            User user = new User();
            user.username = userRegisterRequest.username;
            user.password = passwordEncoder.encode(userRegisterRequest.password);
            user.enabled = true;
            userRepository.save(user);
            return "OK";   // TODO
        }
        return "ERROR";    // TODO
    }
}