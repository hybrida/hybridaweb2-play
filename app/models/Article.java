package models;

import article.routes;
import com.avaje.ebean.annotation.CreatedTimestamp;
import play.db.ebean.Model;
import play.mvc.Call;
import profile.models.User;

import javax.persistence.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Article extends Model implements Revisable<Article> {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(nullable = false)
	Long articleId;
	private String      title;
	private String      ingress;
	@Column(columnDefinition = "text")
	private String      text;
	@OneToOne
	private Article     previousEdit;
	@OneToOne
	private User        author;
	@CreatedTimestamp
	private Timestamp   dateMade;
	private String      imagePath = "/assets/images/logo_big.png";
	@OneToMany
	@OrderBy("Comment.getCreationDate DESC")
	private List<Comment> commentList;

	public Article() {
		title = "Tittel";
		ingress = "Ingress";
		text = "Artikkel";
		commentList = new ArrayList<>();
	}

	@Override
	public void setPrevious(Article article) {
		previousEdit = article;
	}

	@Override
	public Article getPrevious() {
		return previousEdit;
	}

	@Override
	public boolean hasPrevious() {
		return previousEdit != null;
	}

	@Override
	public Long getPreviousId() {
		return getPrevious().getId();
	}

	public Article(Article copy) {
		this.title = copy.title;
		this.ingress = copy.ingress;
		this.text = copy.text;
		this.previousEdit = copy.previousEdit;
		this.author = copy.author;
		this.dateMade = copy.dateMade;
		this.imagePath = copy.imagePath;
		this.commentList = copy.commentList;
	}

	public Article(String title, String text, String ingress, User author, String imagePath) {
		this.title = title;
		this.text = text;
		this.ingress = ingress;
		this.author = author;
		this.imagePath = "/assets/images/logo_big.png";
	}

	public String validate() {
		if (title == null || title.equals(""))
			return "notitle";
		if (ingress == null || ingress.equals(""))
			return "noingress";
		if (text == null || text.equals(""))
			return "notext";
		return null;
	}

	public String toString() {
		return
			"Title: " + title +
			"\nIngress: " + ingress +
			"\nText: " + text +
			(author == null ?
				"\nAuthor: null" :
				"\nAuthor: " + author.toString());
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public String getTitle() { return title; }

	public String getIngress() { return ingress; }

	public String getText() { return text;}

	public Date getDateMade() { return new Date(dateMade.getTime()); }

	public String getImagePath() { return imagePath; }

	public void setDefaultImage() { imagePath = getDefaultImage(); }

	public String getDefaultImage() { return "/assets/images/logo_big.png"; }

	public Long getId() { return articleId;}

	public User getAuthor() { return author; }

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

	public void setAuthor(User author) {
		this.author = author;
	}

	public static Finder<Long, Article> find = new Finder<>(
		Long.class, Article.class
	);

	@Override
	public Call getCreateCall() {
		return article.routes.ArticleIn.index();
	}

	@Override
	public Call getReadCall() {
		return article.routes.Article.viewArticle("" + getId());
	}

	@Override
	public Call getUpdateCall() {
		return article.routes.Article.editArticle("" + getId());
	}

	@Override
	public Call getDeleteCall() {
		return null;
	}
}
