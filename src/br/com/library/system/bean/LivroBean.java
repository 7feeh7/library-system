package br.com.library.system.bean;
import javax.faces.bean.ManagedBean;

import br.com.library.system.model.Livro;

@ManagedBean(name = "livroBean")
public class LivroBean {
	
	private Livro livro = new Livro();

	public Livro getLivro() {
		return livro;
	}
	
	public void cadastrar() {
		System.out.println("Chegou");
	}

}
