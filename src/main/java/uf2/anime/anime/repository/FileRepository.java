package uf2.anime.anime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uf2.anime.anime.domain.model.File;

import java.util.List;
import java.util.UUID;

public interface FileRepository extends JpaRepository<File, UUID> {
    @Query("select fileid from File")
    List<String> getFileIds();
}