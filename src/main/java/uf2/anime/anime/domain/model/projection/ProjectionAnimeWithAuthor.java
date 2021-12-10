package uf2.anime.anime.domain.model.projection;

import java.util.Set;
import java.util.UUID;

public interface ProjectionAnimeWithAuthor {
    UUID getAnimeid();
    String getName();
    String getType();
    String getImageurl();

    Set<ProjectionIdAuthor> getAuthors();
}
