package uf2.anime.anime.domain.model;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public UUID animeid;

    public String name;
    public String description;
    public String type;
    public int year;
    public String imageurl;

    @ManyToMany
    @JoinTable(name = "anime_author", joinColumns = @JoinColumn(name = "animeId"), inverseJoinColumns = @JoinColumn(name = "authorId"))
    public Set<Author> authors;
}
