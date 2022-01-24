package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionAnimeFavorited {
    //UUID getAnimeid();
    //String getName();
    @JsonIgnoreProperties("favoritedby")
    Set<ProjectionAnimeImg> getFavorites();

}
