package br.com.library.system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/morpheus";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException  ex) {
			throw new RuntimeException("Erro ao estabelecer conexão: ", ex);
		}
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println("Error: " + e);
			}
		}
	}

	public static void closeConnection(Connection connection, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException ex) {
				System.err.println("Error: " + ex);
			}
		}
		closeConnection(connection);
	}
	
	public static void closeConnection(Connection connection, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				System.err.println("Error:" + ex);
			}
		}
		closeConnection(connection, ps);
	}

}
