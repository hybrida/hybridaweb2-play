package models;

import play.db.ebean.Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Created by Sindre on 28.01.2015.
 */
@Entity
public class Renders extends Model {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(nullable = false)
	public Long renderId;
	@OneToOne
	public Article articleReference = null;
	@OneToOne
	public Event eventReference = null;

	public static void addArticle(Article article) {
		Renders renders = new Renders();
		renders.articleReference = article;
		renders.save();
	}

	public static void addEvent(Event event) {
		Renders renders = new Renders();
		renders.eventReference= event;
		renders.save();
	}

	public static List<Renders> getVisibleRenderables() {
		List<Renders> renders = Renders.find.orderBy().desc("renderId").findList();
		return renders;
	}

	public static Finder<Long, Renders> find = new Finder<>(
		Long.class, Renders.class
	);
}
