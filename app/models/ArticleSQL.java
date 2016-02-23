package models;

import java.sql.*;
import models.db.Database;
import play.db.ebean.Model;

public class ArticleSQL extends Model {
	public static Long createNewArticle(Long userId) {
		Database db = null;
		Long toReturn = -1L;
		try {
			db = new Database();
			PreparedStatement statement = db.prepare("insert into article (authorId) values (?);");
			statement.setLong(1, userId);
			statement.executeUpdate();
			ResultSet results = statement.getGeneratedKeys();
			if (results.absolute(1)) {
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
