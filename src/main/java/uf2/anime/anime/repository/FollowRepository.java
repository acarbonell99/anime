package uf2.anime.anime.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uf2.anime.anime.domain.model.Favorite;
import uf2.anime.anime.domain.model.UserFollowUser;

import java.util.UUID;

public interface FollowRepository extends JpaRepository<UserFollowUser, UUID> {

}