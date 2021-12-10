package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import uf2.anime.anime.domain.model.Author;

import java.util.Set;
import java.util.UUID;

public interface ProjectionAnime {
    UUID getAnimeid();
    String getName();
    @JsonIgnoreProperties("animes")
    public Set<Author> getAutors();
}
