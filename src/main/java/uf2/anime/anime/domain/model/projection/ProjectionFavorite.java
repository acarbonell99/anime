package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionFavorite {
    @JsonIgnoreProperties("favoritedby")
    Set<ProjectionAnimeFavorited> getFavorites();
}
