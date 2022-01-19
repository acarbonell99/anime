package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface ProjectionAuthor {
    UUID getAuthorid();
    String getName();
    String getImageurl();

    @JsonIgnoreProperties("authors")
    List<ProjectionAnimeImg> getAnimes();
}
