package br.com.library.system.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String URL = "jdbc:mysql://localhost/morpheus";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new RuntimeException("Erro na conexão", e);
		}
	}

}
