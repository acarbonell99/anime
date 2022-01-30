package uf2.anime.anime.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "image_group")
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID imgid;
    public String imgtext;


    @ManyToMany(mappedBy = "images")
    @JsonIgnoreProperties("images")
    public Set<Anime> animes;
}