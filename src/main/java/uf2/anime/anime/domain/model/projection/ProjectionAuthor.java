package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionAuthor {
    UUID authorid();
    String name();
    String getImageurl();
    @JsonIgnoreProperties("authors")
    Set<ProjectionAnime> getAnimes();
}