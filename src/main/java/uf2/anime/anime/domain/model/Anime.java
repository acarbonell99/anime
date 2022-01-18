package uf2.anime.anime.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
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
    @JoinTable(name = "anime_author", joinColumns = @JoinColumn(name = "animeid"), inverseJoinColumns = @JoinColumn(name = "authorid"))
    @JsonIgnoreProperties("animes")
    public Set<Autor> authors;

    @ManyToMany
    @JoinTable(name = "genre_anime", joinColumns = @JoinColumn(name = "animeid"), inverseJoinColumns = @JoinColumn(name = "genreid"))
    @JsonIgnoreProperties("animes")
    public List<Genre> genres;

    @ManyToMany
    @JoinTable(name = "fav", joinColumns = @JoinColumn(name = "animeid"), inverseJoinColumns = @JoinColumn(name = "userid"))
    @JsonIgnoreProperties("animes")
    public Set<User> favoritedby;
}
