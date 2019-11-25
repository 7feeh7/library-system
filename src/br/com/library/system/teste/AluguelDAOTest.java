package br.com.library.system.teste;

import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import br.com.library.system.dao.AluguelDAO;
import br.com.library.system.model.Aluguel;
import br.com.library.system.model.Cliente;
import br.com.library.system.model.Livro;

class AluguelDAOTest {

	@Test
	@Ignore
	void inserir() {
		
		Cliente cliente = new Cliente();
		cliente.setId(12);
		Livro livro = new Livro();
		livro.setId(7);
		
		Aluguel aluguel = new Aluguel();
		aluguel.setCliente(cliente);
		aluguel.setLivro(livro);
		aluguel.setData_emprestimo("2019-11-24");
		aluguel.setData_previsao("2019-12-01");
		aluguel.setData_devolucao("2019-12-07");
		
		AluguelDAO dao = new AluguelDAO();
		if(dao.save(aluguel)) {
			System.out.println("Salvo com sucesso!");
		} else {
			fail("Erro ao salvar");
		}
	}
	
	@Test
	public void listar() {
		AluguelDAO dao = new AluguelDAO();
		
		for(Aluguel l: dao.findAll()) {
			System.out.println("ID:" + l.getId());
			System.out.println("Cliente:" + l.getCliente().getNome());
		}
	}

}
