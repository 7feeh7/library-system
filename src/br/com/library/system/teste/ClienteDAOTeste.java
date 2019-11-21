package br.com.library.system.teste;

import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import br.com.library.system.dao.ClienteDAO;
import br.com.library.system.model.Cliente;

class ClienteDAOTeste {

	public ClienteDAOTeste() {

	}

	@Test
	@Ignore
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
	public void atualizar() {
		Cliente cliente = new Cliente("Teste", "04776215381", "teste@gmail.com", "casa do caralho",
				"85989465100");
		cliente.setId(1);
		ClienteDAO dao = new ClienteDAO();
		if (dao.update(cliente)) {
			System.out.println("Atualizado com sucesso!");
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

}
