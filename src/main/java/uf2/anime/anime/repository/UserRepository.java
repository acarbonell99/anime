package uf2.anime.anime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uf2.anime.anime.domain.model.User;
import uf2.anime.anime.domain.model.projection.ProjectionUser;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);

    <T> List<T> findBy(Class<T> type);

    <T> List<T> findByUsername(String username, Class<T> type);

    //List<ProjectionUser> findBy();

    <T> List<T> findByUserid(UUID id, Class<T> type);
}
