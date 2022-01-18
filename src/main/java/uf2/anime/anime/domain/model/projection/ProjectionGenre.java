package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import uf2.anime.anime.domain.model.Anime;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface ProjectionGenre {
    UUID getGenreid();
    String getLabel();
    String getImageurl();

    //@JsonIgnoreProperties("genres")
    Set<Anime> getAnimes();
}


// SELECT * genreid, label, imageurl from genre