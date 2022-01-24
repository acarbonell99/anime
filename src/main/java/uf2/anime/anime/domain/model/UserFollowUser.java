package uf2.anime.anime.domain.model;

import uf2.anime.anime.domain.model.compositekeys.KeyUserFollowUser;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "following")
@IdClass(KeyUserFollowUser.class)
public class UserFollowUser {

    @Id
    public UUID userid;
    @Id
    public UUID useridfollowed;
}
