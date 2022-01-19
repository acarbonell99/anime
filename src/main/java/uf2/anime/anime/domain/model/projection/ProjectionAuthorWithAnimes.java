package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.UUID;

public interface ProjectionAuthorWithAnimes {
    UUID getAuthorid();
    String getName();
    String getImageurl();

    @JsonIgnoreProperties("authors")
    List<ProjectionAnime> getAnimes();
}
