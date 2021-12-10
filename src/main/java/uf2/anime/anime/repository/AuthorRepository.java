package uf2.anime.anime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uf2.anime.anime.domain.model.Anime;
import uf2.anime.anime.domain.model.projection.ProjectionAuthor;

import java.util.List;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Anime, UUID> {
    List<ProjectionAuthor> findBy();
}
