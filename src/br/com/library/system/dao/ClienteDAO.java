package br.com.library.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.library.system.model.Cliente;

public class ClienteDAO {

	private Connection con = null;

	public ClienteDAO() {
		con = ConnectionFactory.getConnection();
	}

	public boolean save(Cliente cliente) {

		String sql = "INSERT INTO cliente (nome, cpf, email, endereco, telefone) VALUES (?,?,?,?,?)";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getEndereco());
			ps.setString(5, cliente.getTelefone());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: " + e);
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, ps);
		}
	}

	public List<Cliente> findAll() {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM cliente";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setTelefone(rs.getString("telefone"));
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			System.err.println("Erro: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, ps, rs);
		}
		return clientes;
	}

}
