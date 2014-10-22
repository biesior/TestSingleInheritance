package models.db;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@DiscriminatorValue("post")
public class Post extends Content {

    @Id
    public Long id;
    public static Finder<Long, Post> find = new Finder<>(Long.class, Post.class);

    public Date publishDate;


}
