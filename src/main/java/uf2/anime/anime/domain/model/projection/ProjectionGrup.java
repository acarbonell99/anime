package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionGrup {
    UUID getGrupid();
    String getGrupname();

    Set<ProjectionUser> getUsers();
}
