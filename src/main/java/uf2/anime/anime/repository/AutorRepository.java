package uf2.anime.anime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uf2.anime.anime.domain.model.Autor;
import uf2.anime.anime.domain.model.projection.ProjectionAutor;

import java.util.List;
import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
    //List<ProjectionAutor> findBy();
    <T>List<T> findBy(Class<T> type);
}
