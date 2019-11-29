package br.com.library.system.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.library.system.dao.AluguelDAO;
import br.com.library.system.model.Aluguel;
import br.com.library.system.model.Cliente;
import br.com.library.system.model.Livro;

@ManagedBean(name = "aluguelBean", eager = true)
@SessionScoped
public class AluguelBean {
	
	private AluguelDAO dao = null;
	private Aluguel aluguel = new Aluguel();
	private DataModel<Aluguel> alugueis;
	
	public Aluguel getAluguel() {
		return aluguel;
	}
	
	public void setAlugueis(DataModel<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
	
	public void cadastrar() {
		dao = new AluguelDAO();
		aluguel.setData_devolucao(" ");
		if(dao.save(aluguel)) {
			System.out.println("sim");
		} else {
			System.out.println("não");
		}
//		dao = new AluguelDAO();
//		
//		Cliente cliente = new Cliente();
//		cliente.setId(id_cliente);
//		Livro livro = new Livro();
//		livro.setId(id_livvro);
//		
//		if(dao.save(aluguel)) {
//			System.out.println("Cadastrou");
//		} else {
//			System.out.println("Nao cadastrou");
//		}
	}
	
	public DataModel<Aluguel>getAlugueis(){
		dao = new AluguelDAO();
		List<Aluguel> aluguelList = dao.findAll();
		alugueis = new ListDataModel<Aluguel>(aluguelList);
		return alugueis;
	}
	public void excluir(int id) {
		aluguel.setId(id);
		dao = new AluguelDAO();
		if(dao.delete(aluguel)) {
			System.out.println("Deletado com sucesso!");
		} else {
			System.out.println("Erro ao deletar");
		}
	}
}
