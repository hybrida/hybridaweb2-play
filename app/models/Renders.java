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
	public Long articleId = null;
	@OneToOne
	@JoinColumn(name = "event", referencedColumnName = "eventId")
	public Long eventId = null;

	public static void addArticle(Article article) {
		Renders renders = new Renders();
		renders.articleId = article.getId();
		renders.save();
	}

	public static void addEvent(Event event) {
		Renders renders = new Renders();
		renders.eventId = event.getEventId();
		renders.save();
	}

	public static List<Renders> getVisibleRenderables() {
		List<Renders> renders = Renders.find.all();
		return renders;
	}

	public static Finder<Long, Renders> find = new Finder<>(
		Long.class, Renders.class
	);
}
