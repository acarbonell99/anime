package uf2.anime.anime.domain.model.projection;

import java.util.UUID;

public interface ProjectionAutor {
    UUID getAuthorid();
    String getName();
    String getImageurl();
    //@JsonIgnoreProperties("authors")
    //Set<ProjectionAnime> getAnimes();
}
