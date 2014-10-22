package models.db;

import javax.persistence.*;

@Entity
@DiscriminatorValue("news")
public class News extends Content {

    @Id
    public Long id;
    public static Finder<Long, News> find = new Finder<>(Long.class, News.class);

    public String newsSource;


}
