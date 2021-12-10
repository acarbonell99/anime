package uf2.anime.anime.domain.model;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public UUID authorid;

    public String name;
    public String imageurl;

    @ManyToMany(mappedBy = "authors")
    public Set<Anime> animes;
    //@JoinTable(name = "anime_autor", joinColumns = @JoinColumn(name = "animeId"), @JoinColumn(name="authorId"))

}