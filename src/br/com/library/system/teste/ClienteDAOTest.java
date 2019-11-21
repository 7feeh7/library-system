package br.com.library.system.teste;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import br.com.library.system.dao.ClienteDAO;
import br.com.library.system.model.Cliente;

public class ClienteDAOTest {
	 
	public ClienteDAOTest() {
	
	}
	
	@Test
	@Ignore
	public void inserir() {
		Cliente cliente = new Cliente("Testando", "teste", "teste@teste.com", "casa do caralho",
				"85989465100");
		ClienteDAO dao = new ClienteDAO();
		if (dao.save(cliente)) {
			System.out.println("Salvo com sucesso!");
		} else {
			fail("Erro ao salvar");
		}
	}
	
	@Test
	@Ignore
	public void listar() {
		ClienteDAO dao = new ClienteDAO();
		for(Cliente c: dao.findAll()) {
			System.out.print("Nome: " + c.getNome());
			System.out.print("CPF: " + c.getCpf());
			System.out.print("E-mail: " + c.getEmail());
			System.out.print("Endereço: " + c.getEndereco());
			System.out.print("Telefone: " + c.getTelefone());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void atualizar() {
		Cliente cliente = new Cliente("Felipe Pires Soares", "04776215381", "teste@teste.com", "casa do caralho",
				"85989465100");
		cliente.setId(1);
		ClienteDAO dao = new ClienteDAO();
		if (dao.update(cliente)) {
			System.out.println("Atualizado com sucesso!");
		} else {
			fail("Erro ao atualizar");
		}
	}
	
	@Test
	@Ignore
	public void deletar() {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		ClienteDAO dao = new ClienteDAO();
		if (dao.delete(cliente)) {
			System.out.println("Deletado com sucesso!");
		} else {
			fail("Erro ao atualizar");
		}
	}

}
