package uf2.anime.anime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uf2.anime.anime.domain.model.User;

public interface UserRepository extends JpaRepository {
    User findByUsername(String username);
}
