package br.com.library.system.model;

public class Livro {
	
	private int id;
	private String titulo;
	private String autor;
	private String categoria;
	private String data_publicacao;
	
	public Livro() {
		
	}
	
	public Livro(String titulo, String autor, String categoria, String data_publicacao) {
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.data_publicacao = data_publicacao;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getData_publicacao() {
		return data_publicacao;
	}

	public void setData_publicacao(String data_publicacao) {
		this.data_publicacao = data_publicacao;
	}

}
