package uf2.anime.anime.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import uf2.anime.anime.domain.model.Anime;
import java.util.List;
import java.util.UUID;

public interface AnimeRepository extends JpaRepository<Anime, UUID>, JpaSpecificationExecutor<Anime> {
    //List<ProjectionAnime> findBy();
    <T> List<T> findBy(Class<T> type);
    <T> List<T> findByAnimeid(UUID id, Class<T> type);

}