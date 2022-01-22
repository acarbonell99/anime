package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import uf2.anime.anime.domain.model.Anime;

import java.util.Set;
import java.util.UUID;

public interface ProjectionUser {
    UUID getUserid();
    String getUsername();
    //@JsonIgnoreProperties("faviritedby")
    //Set<Anime> getFavorites();
}
