package models;

import play.db.ebean.Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.*;

/**
 * Created by Sindre on 28.01.2015.
 */
@javax.persistence.Entity
public class Renders extends Model {

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
		renders.eventReference= event;
		renders.save();
	}

	public static List<Renders> getVisibleRenderables() {
		List<Renders> renders = Renders.find.orderBy().desc("renderId").findList();
		return renders;
	}

	public static Renders getByEventId(Long eventId) {
		return find.where().eq("eventReference.eventId", eventId).findUnique();
	}

	public static Finder<Long, Renders> find = new Finder<>(
		Long.class, Renders.class
	);
}
