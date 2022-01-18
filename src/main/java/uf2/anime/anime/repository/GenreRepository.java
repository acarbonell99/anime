package uf2.anime.anime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uf2.anime.anime.domain.model.Genre;

import java.util.List;
import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID> {
    <T> List<T> findBy(Class<T> type);
}
