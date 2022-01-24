package uf2.anime.anime.domain.model.projection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import uf2.anime.anime.domain.model.User;

import java.util.Set;
import java.util.UUID;

public interface ProjectionUserFollowUser {
    UUID getUserid();
    String getUsername();
    @JsonIgnoreProperties("followby")
    Set<ProjectionUser> getFollow();
}
