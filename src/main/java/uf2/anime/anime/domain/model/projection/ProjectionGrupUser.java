package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionGrupUser {
    UUID getUserid();
    String getUsername();

    @JsonIgnoreProperties("users")
    Set<ProjectionGrup> getGrups();
}
