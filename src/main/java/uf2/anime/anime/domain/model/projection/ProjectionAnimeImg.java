package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionAnimeImg {
    UUID getAnimeid();
    String getName();
    String getImageurl();

    Set<ProjectionImages> getImages();
}
