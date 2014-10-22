package models.db;

import javax.persistence.*;

@Entity
@DiscriminatorValue("video")
public class Video extends Content {

    @Id
    public Long id;
    public static Finder<Long, Video> find = new Finder<>(Long.class, Video.class);

    public String videoPath;
}
