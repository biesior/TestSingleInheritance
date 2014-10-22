package models.db;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "content")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("content")
public abstract class Content extends Model {

    @Id
    public Long id;

    @Column(name = "dtype", insertable = false, updatable = false)
    public String dtype;

    public static Finder<Long, Content> find = new Finder<>(Long.class, Content.class);

    public String title;
    public Date created = new Date();
    public Date modified = new Date();


}
