package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionAnimeWithAuthor {
    UUID getAnimeid();
    String getName();
    String getType();
    String getImageurl();

    @JsonIgnoreProperties("animes")
    Set<ProjectionAuthorMin> getAuthors();

    @JsonIgnoreProperties("animes")
    Set<ProjectionGenre> getGenres();
}
