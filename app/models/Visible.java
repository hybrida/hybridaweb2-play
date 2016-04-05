package models;

import java.sql.*;
import models.db.Database;
import play.db.ebean.Model;

public class Visible extends Model {

	public static void setArticleVisible(Long articleId) {
		Database db = null;
		try {
			db = new Database();
			PreparedStatement statement = db.prepare("insert into visible (\"articleId\") values (?);");
			statement.setLong(1, articleId);
			statement.executeUpdate();
			ResultSet results = statement.getGeneratedKeys();
			if (results.next()) {
				db.commit();
			} else {
				throw new RuntimeException("Could not fetch the newly generated key");
			}
		} catch (Exception exception) {
			System.out.println(exception);
		} finally {
			db.close();
		}
	}

}
