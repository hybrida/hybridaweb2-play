package models;

import java.sql.*;
import models.db.Database;
import play.db.ebean.Model;

public class ArticleSQL extends Model {

	public String title, ingress, text;

	public ArticleSQL() {
		title = null;
		ingress = null;
		text = null;
	}

	public Long createNewArticle(Long userId) {
		return createNewArticle(userId, null);
	}

	public void viewArticle(String id) {
		Database db = null;
		Long toReturn = -1L;
		try {
			db = new Database();
			PreparedStatement statement = db.prepare(
				"select * from article;"
			);
			// statement.setLong(1, Long.valueOf(id));
			System.out.println("HeyAA!");
			ResultSet results = statement.executeQuery();
			System.out.println("Hey!");
			while (results.next()) {
				System.out.println(results);
			}
		} catch (Exception exception) {
			System.out.println(exception);
		} finally {
			db.close();
		}
	}

	public Long createNewArticle(Long userId, String imagePath) {
		Database db = null;
		Long toReturn = -1L;
		try {
			db = new Database();
			PreparedStatement statement = db.prepare(
				"insert into article (\"authorId\", title, ingress, text, \"imagePath\") values (?, ?, ?, ?, ?);");
			statement.setLong(1, userId);
			statement.setString(2, title);
			statement.setString(3, ingress);
			statement.setString(4, text);
			statement.setString(5, imagePath);
			statement.executeUpdate();
			ResultSet results = statement.getGeneratedKeys();
			if (results.next()) {
				toReturn = results.getLong(1);
				db.commit();
			} else {
				throw new RuntimeException("Could not fetch the newly generated key");
			}
		} catch (Exception exception) {
			System.out.println(exception);
		} finally {
			db.close();
		}
		return toReturn;
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

}
