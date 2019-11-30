package br.com.library.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.library.system.model.Livro;

public class LivroDAO {
	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public LivroDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean save(Livro livro) {
		String sql = "INSERT INTO livro(titulo, autor, categoria, data_publicacao) values(?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, livro.getTitulo());
			ps.setString(2, livro.getAutor());
			ps.setString(3, livro.getCategoria());
			ps.setString(4, livro.getData_publicacao());
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			System.err.println("Ocorreu um erro: " + ex);
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, ps);
		}
	}

	public List<Livro> findAll() {
		List<Livro> livros = new ArrayList<Livro>();
		String sql = "SELECT * FROM livro";
		String date;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Livro livro = new Livro();
				livro.setId(rs.getInt("id"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setCategoria(rs.getString("categoria"));
				livro.setData_publicacao(rs.getString("data_publicacao"));
				livros.add(livro);
			}

		} catch (SQLException ex) {
			System.err.println("Erro: " + ex);
		} finally {
			ConnectionFactory.closeConnection(connection, ps, rs);
		}
		return livros;
	}

	public boolean delete(Livro livro) {
		String sql = "DELETE FROM livro WHERE id=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, livro.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: " + e);
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, ps);
		}
	}

	public boolean update(Livro livro) {
		String sql = "UPDATE livro set titulo=?, autor=?, categoria=?, data_publicacao=? WHERE id=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, livro.getTitulo());
			ps.setString(2, livro.getAutor());
			ps.setString(3, livro.getCategoria());
			ps.setString(4, livro.getData_publicacao());
			ps.setInt(5, livro.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			System.err.println("Erro: " + ex);
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, ps);
		}
	}
}
