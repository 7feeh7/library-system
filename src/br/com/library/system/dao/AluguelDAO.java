package br.com.library.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.library.system.model.Aluguel;
import br.com.library.system.model.Cliente;
import br.com.library.system.model.Livro;

public class AluguelDAO {
	
	private Connection connection = null;
	
	public AluguelDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public boolean save(Aluguel aluguel) {
		String sql = "INSERT INTO emprestimo (id_cliente, id_livro, data_empre"
				+ "stimo, data_previsao) VALUES (?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, aluguel.getCliente_id());
			ps.setInt(2, aluguel.getLivro_id());
			ps.setString(3, aluguel.getData_emprestimo().replace("/", ""));
			ps.setString(4, aluguel.getData_previsao().replace("/", ""));
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("Erro: " + e);
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, ps);
		}
	}
	
	public List<Aluguel> findAll() {
		
		String sql = "SELECT e.id AS id,"
				+ " c.id AS cliente_id,"
				+ " c.nome AS cliente_nome,"
				+ " l.id AS livro_id,"
				+ " l.titulo AS livro_titulo,"
				+ " e.data_emprestimo AS dt_emprestimo,"
				+ " e.data_previsao AS dt_previsao,"
				+ " e.data_devolucao AS dt_devolucao"
				+ " FROM emprestimo AS e "
				+ "INNER JOIN cliente AS c"
				+ " ON e.id_cliente = c.id "
				+ "INNER JOIN livro AS l "
				+ "ON e.id_livro = l.id";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Aluguel> alugueis = new ArrayList<>();
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		String dt_emprestimo, dt_previsao;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Aluguel aluguel = new Aluguel();
				aluguel.setId(rs.getInt("id"));
				
				Cliente cliente =  new Cliente();
				cliente.setId(rs.getInt("cliente_id"));
				cliente.setNome(rs.getString("cliente_nome"));
				aluguel.setCliente(cliente);
				
				Livro livro = new Livro();
				livro.setId(rs.getInt("livro_id"));
				livro.setTitulo(rs.getString("livro_titulo"));
				aluguel.setLivro(livro);
				
				dt_emprestimo = dataFormatada.format(rs.getDate("dt_emprestimo"));
				aluguel.setData_emprestimo(dt_emprestimo);
				
				dt_previsao = dataFormatada.format(rs.getDate("dt_previsao"));
				aluguel.setData_previsao(dt_previsao);

				aluguel.setData_devolucao(rs.getString("dt_devolucao"));
			
				alugueis.add(aluguel);
			}
		} catch (SQLException e) {
			System.err.println("Erro: " + e);
		} finally {
			ConnectionFactory.closeConnection(connection, ps, rs);
		}
		return alugueis;
	}
	
	public boolean update(Aluguel aluguel) {
		PreparedStatement ps = null;
		String sql = "UPDATE emprestimo set data_devolucao=? WHERE id=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, aluguel.getData_devolucao());
			ps.setInt(2, aluguel.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			System.err.println("Erro: " + ex);
			return false;
		} finally {
			ConnectionFactory.closeConnection(connection, ps);
		}
	}
	
	public boolean delete(Aluguel aluguel) {
		String sql = "DELETE FROM emprestimo WHERE id=?";
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1,aluguel.getId());
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
