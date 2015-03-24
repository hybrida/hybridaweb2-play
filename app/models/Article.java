package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import play.db.ebean.Model;
import play.twirl.api.Html;
import views.html.Article.articleRenderFrontPageSample;

import javax.persistence.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
public class Article extends Model implements Renderable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    Long articleId;
    private String      title;
    private String      ingress;
    @Column(columnDefinition = "text")
    private String      text;
    @OneToOne
    private Long        author;
    @CreatedTimestamp
    private Timestamp   dateMade;
    private String      imagePath;

    public Article(String title, String text, String ingress, Long author, String imagePath) {
        this.title = title;
        this.text = text;
        this.ingress = ingress;
        this.author = author;
        this.imagePath = imagePath;
    }

    public String getTitle() { return title; }

    public String getIngress() { return ingress; }

    public String getText() { return text;}

    public Date getDateMade() { return new Date(dateMade.getTime()); }

    public String getImagePath() { return imagePath;}

    public Long getId() { return articleId;}

    public Long getAuthor() {    return author; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIngress(String ingress) {
        this.ingress = ingress;
    }

    public void setId(Long id) {
        this.articleId = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public static String getArticleData() throws SQLException {

        List<Article> entities = Article.find.all();
        return "";
        /*
        javax.sql.DataSource ds = DB.getDataSource();
        java.sql.Connection connection = ds.getConnection("hybrid", "");
        java.sql.Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM feed");

        result.absolute(1);
        int length = result.getInt(1);
        result = statement.executeQuery("SELECT * FROM feed ORDER BY id DESC");

        String finalPost = "";
        for (int i = 1; i <= length; ++i) {
            result.absolute(i);
            String check = result.getString(3);
            String url = routes.Feed.generateArticle(result.getString(1).replace(" ", "_")).absoluteURL(request());
            if (!check.equalsIgnoreCase("null")) {
                finalPost += "<a href=" + url +"><div class=\"content2\">" +
                        "<div style=\"border-bottom: 2px solid  #9e9d98 \">" +
                        "<img src=\"/assets/Upload/" + result.getString(3) + "\" alt=\"rect\" width=50% height=50%/><br>" +
                        escapeText.apply(result.getString(2).toUpperCase()).toString().replace("\n", "<br />") + "</div></a><br>" +
                        escapeText.apply(result.getString(5)).toString().replace("\n", "<br />") + "</div>";
            }
            else {
                finalPost += "<a href=" + url +"><div class=\"content2\">" +
                        "<div style=\"border-bottom: 2px solid  #9e9d98 \">" +
                        "<img src=\"/assets/images/favicon.ico\" alt=\"rect\"/><br>" +
                        escapeText.apply(result.getString(2).toUpperCase()).toString().replace("\n", "<br />") + "</a></div><br>" +
                        escapeText.apply(result.getString(5)).toString().replace("\n", "<br />") + "</div>";

            }
        }

        return finalPost;
        */
    }

    public Html renderFrontPageSample() {
        if (imagePath == null)
            imagePath = "/assets/images/logo_big.png";
        return articleRenderFrontPageSample.render(this);
    }

    public Html renderFull() {
        return Html.apply("NOT IMPLEMENTED");
    }

    public static Finder<Long, Article> find = new Finder<>(
            Long.class, Article.class
    );
}
