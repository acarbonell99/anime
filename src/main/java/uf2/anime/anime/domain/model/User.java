package uf2.anime.anime.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "usser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID userid;

    public String username;
    public String password;
    public String email;
    public int phone;
    public String role;
    public boolean enabled;

    @ManyToMany(mappedBy = "favoritedby")
    //@JsonIgnoreProperties("favoritedby")
    public Set<Anime> favorites;

    @ManyToMany
    @JoinTable(name = "following", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "useridfollowed"))
    public Set<User> follow;

    /*@ManyToMany
    @JoinTable(name = "user_group", joinColumns = @JoinColumn(name = "groupid"), inverseJoinColumns = @JoinColumn(name = "userid"))
    public Set<Grup> grup;*/
    @ManyToMany(mappedBy = "users")
    @JsonIgnoreProperties("users")
    public Set<Grup> grups;

    /*@ManyToMany
    @JoinTable(name = "user_grup", joinColumns = @JoinColumn(name = "grupid"), inverseJoinColumns = @JoinColumn(name = "userid"))
    @JsonIgnoreProperties("users2")
    public Set<Grup> grups2;

     */


}