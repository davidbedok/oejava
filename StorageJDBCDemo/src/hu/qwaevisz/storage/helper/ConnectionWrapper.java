package hu.qwaevisz.storage.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionWrapper {

	private final Connection connection;

	public ConnectionWrapper() throws ClassNotFoundException, SQLException {
		Class.forName(ConnectionInfo.JDBC_DRIVER);
		this.connection = DriverManager.getConnection(ConnectionInfo.DB_URL, ConnectionInfo.USERNAME, ConnectionInfo.PASSWORD);
	}

	public Statement createStatement() throws SQLException {
		return this.connection.createStatement();
	}

	public PreparedStatement createPrepareStatement(String sql) throws SQLException {
		return this.connection.prepareStatement(sql);
	}

	public void commit() throws SQLException {
		this.connection.commit();
	}

}
