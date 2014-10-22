package controllers;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;
import models.db.Content;
import models.db.News;
import models.db.Post;
import models.db.Video;
import models.view.ApplicationIndex;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Application extends Controller {

    public static Result index() {
//        deleteDummyData();
        insertDummyData();

        ApplicationIndex data = new ApplicationIndex();
        data.pageTitle = "Ellou' Inheritance";
        data.contents = Content.find.select("id, dtype, title, created").where().orderBy("dtype ASC").findList();

        return ok(index.render(data));
    }

    private static void deleteDummyData() {
        SqlUpdate down = Ebean.createSqlUpdate("DELETE FROM content WHERE 1");
        down.execute();
    }

    private static void insertDummyData() {
        if (Content.find.findRowCount() == 0) {

            List<String> types = Arrays.asList("news", "video", "post");

            for (String type : types) {

                for (int i = 1; i <= 3; i++) {
                    Content content = null;

                    switch (type) {
                        case "news":
                            News news = new News();
                            news.newsSource = "Newspaper X";
                            content = news;
                            break;
                        case "video":
                            Video video = new Video();
                            video.videoPath = "foo.mp4";
                            content = video;
                            break;
                        case "post":
                            Post post = new Post();
                            post.publishDate = new Date();
                            content = post;
                            break;
                    }
                    if (content != null) {
                        content.title = type + " " + i;
                        content.save();
                    }
                }
            }
        }
    }

}
