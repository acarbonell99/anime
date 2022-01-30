package uf2.anime.anime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uf2.anime.anime.domain.model.Grup;

import java.util.List;
import java.util.UUID;

public interface GrupRepository extends JpaRepository<Grup, UUID> {
    <T> List<T> findBy(Class<T> type);
    <T> List<T> findByGrupid(UUID id, Class<T> type);

}
