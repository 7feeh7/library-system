package br.com.library.system.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.library.system.connection.ConnectionFactory;

public class TesteInsere {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = new ConnectionFactory().getConnection();
			
			String sql = "insert into cliente"
					+ "(nome, cpf, email, endereco, telefone)"
					+ " values(?,?,?,?,?)";
			ps  = con.prepareStatement(sql);
			
			ps.setString(1, "TEste Pires");
			ps.setString(2, "66666666666");
			ps.setString(3, "teste@teste.com");
			ps.setString(4, "casa do caralho");
			ps.setString(5, "85989465100");
			ps.execute();
			System.out.println("Gravado!");
		} catch (Exception e) {
			System.err.println("Erro:" + e);
		} finally {
			ps.close();
			con.close();
		}
		
	}

}
