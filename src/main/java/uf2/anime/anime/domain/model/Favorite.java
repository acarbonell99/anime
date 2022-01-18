package uf2.anime.anime.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "favorite")
public class Favorite {
    @Id
    public UUID animeid;
    public UUID userid;
}
