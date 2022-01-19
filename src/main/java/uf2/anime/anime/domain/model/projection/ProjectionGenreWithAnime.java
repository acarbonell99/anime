package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionGenreWithAnime {
    UUID getGenreid();
    String getLabel();

    @JsonIgnoreProperties("genres")
    Set<ProjectionAnimeWithAuthor> getAnimes();
}
