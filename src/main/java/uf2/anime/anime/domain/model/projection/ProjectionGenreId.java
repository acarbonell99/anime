package uf2.anime.anime.domain.model.projection;

import java.util.Set;
import java.util.UUID;

public interface ProjectionGenreId {
    UUID getGenreid();
    String getLabel();
    String getImageurl();

    Set<ProjectionAnimeWithAuthorYear> getAnimes();
}
