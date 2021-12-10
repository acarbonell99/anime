package uf2.anime.anime.repository;

import java.util.List;

public interface GenreRepository {
    <T> List<T> findBy(Class<T> type);
}
