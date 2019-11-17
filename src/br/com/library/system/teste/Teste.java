package br.com.library.system.teste;

import java.sql.Connection;
import java.sql.SQLException;
import br.com.library.system.connection.ConnectionFactory;

public class Teste {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta");
		connection.close();
	}

}
