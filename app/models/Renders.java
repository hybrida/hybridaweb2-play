package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sindre on 28.01.2015.
 */
@Entity
public class Renders extends Model {

    @OneToOne
    @JoinColumn(name = "article", referencedColumnName = "articleId")
    Long articleId;
    @OneToOne
    @JoinColumn(name = "event", referencedColumnName = "eventId")
    Long eventId;

    public static void addArticle(Article article) {
        Renders renders = new Renders();
        renders.articleId = article.getId();
        renders.save();
    }

    public static List<Article> getVisibleArticles() {
        List<Renders> renders = Renders.find.all();
        List<Article> articles = new ArrayList<>();
        for (Renders render : renders)
            articles.add(Article.find.byId(render.articleId));
        return articles;
    }

    public static Finder<Long, Renders> find = new Finder<>(
            Long.class, Renders.class
    );
}
