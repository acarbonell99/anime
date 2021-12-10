package uf2.anime.anime.domain.model.projection;

import java.util.Set;
import java.util.UUID;

public interface ProjectionAnimeWithAuthorYear {
    UUID getAnimeid();
    String getName();
    String getType();
    int getYear();
    String getImageurl();

    Set<ProjectionIdAuthor> getAuthors();
}
