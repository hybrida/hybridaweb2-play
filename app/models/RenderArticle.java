package models;

import play.db.ebean.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bourgond on 1/28/2015.
 */
@Entity
public class RenderArticle extends Model {

    public static Finder<Long, RenderArticle> find = new Finder<>(
            Long.class, RenderArticle.class
    );

    @OneToOne
    private Article article;

    public static List<Article> getVisibleArticles() {
        List<RenderArticle> renderArticles = RenderArticle.find.all();
        List<Article> articles = new ArrayList<>();
        for (RenderArticle renderArticle : renderArticles) {
            articles.add(renderArticle.article);
        }
        return articles;
    }

}
