package models.db;

import java.sql.*;

public class Database {

	Connection connection = null;

	public Database() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(
				"jdbc:postgresql://localhost/hybrida",
				"hybrida", "");
			connection.setAutoCommit(false);
		} catch (Exception exc) {
			throw new RuntimeException(exc);
		}
	}

	public PreparedStatement prepare(String sql) {
		try {
			return connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException exception) {
			throw new RuntimeException(exception);
		}
	}

	public void commit() {
		try {
			connection.commit();
		} catch (SQLException exception) {
			throw new RuntimeException(exception);
		}
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException exc) {
			throw new RuntimeException(exc);
		}
	}

	public Connection get() {
		return connection;
	}

}
