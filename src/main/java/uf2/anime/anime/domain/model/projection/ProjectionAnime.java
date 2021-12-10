package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import uf2.anime.anime.domain.model.Author;
import uf2.anime.anime.domain.model.Genre;

import java.util.Set;
import java.util.UUID;

public interface ProjectionAnime {
    UUID getAnimeid();
    String getName();
    String getDescription();
    String getType();
    int getYear();
    String getImageurl();
    @JsonIgnoreProperties("animes")
    Set<Author> getAutors();
    @JsonIgnoreProperties("animes")
    Set<Genre> getGenres();
}
