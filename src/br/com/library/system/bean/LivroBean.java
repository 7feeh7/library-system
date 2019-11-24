package br.com.library.system.bean;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.library.system.dao.LivroDAO;
import br.com.library.system.model.Livro;

@ManagedBean(name = "livroBean")
@SessionScoped
public class LivroBean {
	
	private LivroDAO dao = null;
	private Livro livro = new Livro();
	private DataModel<Livro> livros;
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setClientes(DataModel<Livro> livros) {
		this.livros = livros;
	}
	
	public String selecionar() {
		livro = livros.getRowData();
		return "/editar-livro.xhtml?faces-redirect=true";
	}
	
	public String cadastrar() {
		dao = new LivroDAO();
		if(dao.save(livro)) {
			return "/listar-livro.xhtml?faces-redirect=true";
		} else {
			return "/cadastrar-livro.xhtml?faces-redirect=true";
		}
	}
	
	public String alterar(int id) {
		dao = new LivroDAO();
		livro.setId(id);
		if(dao.update(livro)) {
			return "/listar-livro.xhtml?faces-redirect=true";
		} else {
			return "/editar-livro.xhtml?faces-redirect=true";
		}
	}
	
	public DataModel<Livro>getLivros(){
		dao = new LivroDAO();
		List<Livro> livroList = dao.findAll();
		livros = new ListDataModel<Livro>(livroList);
		return livros;
	}
	
	public void excluir(int id) {
		try {
			livro.setId(id);
			dao = new LivroDAO();
			if (dao.delete(livro)) {
				System.out.println("Deletado com sucesso");
			} else {
				System.out.println("Erro ao deletar");
			}
		} catch (Exception ex) {
			System.out.println("Erro: " + ex);
		}
	}

}
