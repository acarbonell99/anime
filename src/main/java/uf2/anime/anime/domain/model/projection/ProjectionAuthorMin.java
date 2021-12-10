package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionAuthorMin {
    UUID authorid();
    String name();
    String getImageurl();

    Set<ProjectionAnimeMin> getAnimes();
}
