package uf2.anime.anime.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @JsonIgnoreProperties("movies")
    public Set<Author> authors;

    @ManyToMany
    @JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movieid"), inverseJoinColumns = @JoinColumn(name = "genreid"))
    @JsonIgnoreProperties("movies")
    public Set<Genre> genres;
}
