package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.UUID;

public interface ProjectionAuthorMin {
    UUID getAuthorid();
    String getName();
}
