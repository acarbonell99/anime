package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionAnimeImg {
    UUID getAnimeid();
    String getName();
    String getImageurl();
    String getDescription();
    String getType();
    int getYear();


    Set<ProjectionImages> getImages();
}
