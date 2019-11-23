package br.com.library.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

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
	
	public Cliente edit(int id) {
		String sql = "SELECT * FROM cliente id="+(id);
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente cliente = new Cliente();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs != null) {
				rs.next();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setTelefone(rs.getString("telefone"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			ConnectionFactory.closeConnection(con, ps, rs);
		}
		return cliente;
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
				cliente.setId(rs.getInt("id"));
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
	
	public boolean update(Cliente cliente) {

		String sql = "UPDATE cliente set nome=?, cpf=?, email=?, endereco=?, telefone=? WHERE id=?";

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getEndereco());
			ps.setString(5, cliente.getTelefone());
			ps.setInt(6, cliente.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: " + e);
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, ps);
		}
	}
	
	public boolean delete(Cliente cliente) {
		String sql = "DELETE FROM cliente WHERE id=?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cliente.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: " + e);
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, ps);
		}
	}

}
