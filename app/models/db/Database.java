package models.db;

import java.sql.*;

public class Database {

	Connection connection = null;

	public Database() {
		try {
			connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/hybrida",
				"username", "password");
			connection.setAutoCommit(false);
		} catch (SQLException exc) {
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
