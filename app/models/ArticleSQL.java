package models;

import java.sql.*;
import models.db.Database;
import play.db.ebean.Model;

public class ArticleSQL extends Model {
	public static Long createNewArticle(Long userId) {
		return createNewArticle(userId, "", "", "");
	}

	public static Long createNewArticle(Long userId,
	                                    String title,
	                                    String ingress,
	                                    String text) {
		Database db = null;
		Long toReturn = -1L;
		try {
			db = new Database();
			System.out.println(db);
			PreparedStatement statement = db.prepare("insert into article (authorId, title, ingress, text) values (?, ?, ?, ?);");
			statement.setLong(1, userId);
			statement.setString(2, title);
			statement.setString(3, ingress);
			statement.setString(4, text);
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

}
