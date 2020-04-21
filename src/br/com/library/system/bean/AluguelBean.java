package br.com.library.system.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.library.system.dao.AluguelDAO;
import br.com.library.system.model.Aluguel;

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
	public String selecionar() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		aluguel = alugueis.getRowData();
		aluguel.setData_devolucao(dateFormat.format(date));
		return "/editar-emprestimo.xhtml?faces-redirect=true";
	}
	
	public String cadastrar() {
		dao = new AluguelDAO();
		aluguel.setData_devolucao(" ");
		if(dao.save(aluguel)) {
			return "/listar-emprestimo.xhtml?faces-redirect=true";
		} else {
			return "/cadastrar-emprestimo.xhtml?faces-redirect=true";
		}
	}
	
	public DataModel<Aluguel>getAlugueis(){
		dao = new AluguelDAO();
		List<Aluguel> aluguelList = dao.findAll();
		alugueis = new ListDataModel<Aluguel>(aluguelList);
		return alugueis;
	}
	public String alterar(int id) {
			dao = new AluguelDAO();
			aluguel.setId(id);
			if(dao.update(aluguel)) {
				return "/listar-emprestimo.xhtml?faces-redirect=true";
			} else {
				return "/editar-emprestimo.xhtml?faces-redirect=true";
			}
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
