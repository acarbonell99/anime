package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.Set;
import java.util.UUID;

public interface ProjectionAnime {
    UUID getAnimeid();
    String getName();
    String getDescription();
    String getType();
    int getYear();
    String getImageurl();
    String getVideo();

    @JsonIgnoreProperties("animes")
    Set<ProjectionAuthor> getAuthors();

    @JsonIgnoreProperties("animes")
    Set<ProjectionGenre> getGenres();

    @JsonIgnoreProperties("animes")
    Set<ProjectionUser> getFavoritedby();

}
