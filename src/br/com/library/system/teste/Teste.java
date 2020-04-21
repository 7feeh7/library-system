package br.com.library.system.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.library.system.dao.ConnectionFactory;

public class Teste {
	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		System.out.println("Conexao aberta!");
		connection.close();
	}
}
