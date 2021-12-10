package uf2.anime.anime.domain.model.projection;

import java.util.Set;
import java.util.UUID;

public interface ProjectionGenre {
    UUID getGenreid();
    String getLabel();
    String getImageurl();

    Set<ProjectionAnimeWithAuthor> getAnimes();
}
