package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import uf2.anime.anime.domain.model.Autor;
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
    Set<ProjectionAutor> getAuthors();

    //@JsonIgnoreProperties("animes")
    //Set<ProjectionGenre> getGenres();
}
