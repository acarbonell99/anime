package uf2.anime.anime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uf2.anime.anime.domain.model.File;
import uf2.anime.anime.domain.model.projection.ProjectionAnime;

import java.util.List;
import java.util.UUID;

public interface FileRepository extends JpaRepository<File, UUID> {
    <T> List<T> findBy(Class<T> type);
    //List<File> findBy();
}