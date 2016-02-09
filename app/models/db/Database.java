package models.db;

import java.sql.*;

class Database {

	Connection connection = null;

	public Database() throws SQLException {
		// Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
			"jdbc:mysql://hostname:port/dbname",
			"username", "password");
	}

	public void close() throws SQLException {
		connection.close();
	}

	public Connection get() {
		return connection;
	}

}
