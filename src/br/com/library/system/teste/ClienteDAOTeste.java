package br.com.library.system.teste;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import br.com.library.system.model.Cliente;
import br.com.library.system.dao.ClienteDAO;

class ClienteDAOTeste {

	public ClienteDAOTeste() {

	}

	@Test
	public void inserir() {
		Cliente cliente = new Cliente("Felipe Pires", "aaaa", "teste@teste.com", "casa do caralho",
				"85989465100");
		ClienteDAO dao = new ClienteDAO();
		if (dao.save(cliente)) {
			System.out.println("Salvo com sucesso!");
		} else {
			fail("Erro ao salvar");
		}
	}
	
	@Test
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

}
