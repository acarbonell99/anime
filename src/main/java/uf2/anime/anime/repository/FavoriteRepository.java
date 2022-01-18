package uf2.anime.anime.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uf2.anime.anime.domain.model.Anime;
import uf2.anime.anime.domain.model.Favorite;

import java.util.List;
import java.util.UUID;

public interface FavoriteRepository extends JpaRepository<Favorite, UUID> {
}