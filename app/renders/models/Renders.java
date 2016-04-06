package renders.models;

import models.Article;
import models.Event;
import play.db.ebean.Model;

import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.*;
import play.twirl.api.Html;

/**
 * Created by Sindre on 28.01.2015.
 */
@javax.persistence.Entity
public class Renders extends Model implements Searchable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(nullable = false)
	public Long renderId;
	@OneToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	public Article articleReference = null;
	@OneToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	public Event eventReference = null;

	public static void addArticle(Article article) {
		Renders renders = new Renders();
		renders.articleReference = article;
		renders.save();
	}

	public static void addEvent(Event event) {
		Renders renders = new Renders();
		renders.eventReference = event;
		renders.save();
	}

	public static List<Renders> getVisibleRenderables() {
		List<Renders> renders = Renders.find.orderBy().desc("renderId").findList();
		return renders;
	}

	public static Renders getByEventId(Long eventId) {
		return find.where().eq("eventReference.eventId", eventId).findUnique();
	}

	public static Renders getByArticleId(Long articleId) {
		return find.where().eq("articleReference.articleId", articleId).findUnique();
	}

	public Article getArticle() {
		if(eventReference != null) return eventReference.getArticle();
		else return articleReference;
	}

	@Override
	public Html render() {
//		System.out.println(articleReference);
		if(eventReference != null) return renders.views.html.eventRender.render(eventReference.getArticle(), eventReference);
		return renders.views.html.articleRender.render(articleReference);
	}

	public static Model.Finder<Long, Renders> find = new Finder<>(
			Long.class, Renders.class
	);

	private static final String EVENT_HEAD_SEARCH_PREFIX = "eventReference.articleRef.";
	private static final String ARTICLE_SEARCH_PREFIX = "articleReference.";

	public static List<Renders> search(String term) {
		String key = "%"+ term + "%";
		return renders.models.Renders.find.where(
		).disjunction()
				.like(ARTICLE_SEARCH_PREFIX + "ingress", key)
				.like(ARTICLE_SEARCH_PREFIX + "title", key)
				.like(ARTICLE_SEARCH_PREFIX + "text", key)
				.like(EVENT_HEAD_SEARCH_PREFIX + "ingress", key)
				.like(EVENT_HEAD_SEARCH_PREFIX + "title", key)
				.like(EVENT_HEAD_SEARCH_PREFIX + "text", key)
				.endJunction().findList();
	}

	@Override
	public String getMatchString() {
		return getArticle().getTitle() + "\n"
				+ getArticle().getIngress() + "\n"
				+ getArticle().getText();
	}

	@Override
	public String getSearchHandle() {
		return getArticle().getTitle();
	}
}
