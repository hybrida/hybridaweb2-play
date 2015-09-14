package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by eliasbragstadhagen on 25.03.15.
 */
@Entity
public class Comment extends Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentID;
	private String comment;
	@ManyToOne
	private User author;
	@CreatedTimestamp
	private Timestamp createdDate;
	@ManyToOne
	private Article article;

	public Article getArticle() {
		return article;
	}

	public Comment(String comment, Article article){
		this.comment = comment;
		author = LoginState.getUser();
		this.article = article;
	}

	public Long getCommentID() {
		return commentID;
	}

	public String getComment() {
		return comment;
	}

	public User getAuthor() {
		return author;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public static Finder<Long, Comment> find = new Finder<Long, Comment>(
		Long.class, Comment.class
	);

	public String getTimestamp(){
		String time = createdDate.toString();
		time = time.substring(0, time.length() - 4);
		return time;
	}
}
