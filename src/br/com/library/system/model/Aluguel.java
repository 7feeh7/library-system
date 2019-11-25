package br.com.library.system.model;

public class Aluguel {

	private int id;
	private Cliente cliente;
	private Livro livro;
	private String data_emprestimo;
	private String data_previsao;
	private String data_devolucao;

	public Aluguel() {

	}

	public Aluguel(Cliente cliente, Livro livro, String data_emprestimo, String data_previsao, String data_devolucao) {
		this.cliente = cliente;
		this.livro = livro;
		this.data_emprestimo = data_emprestimo;
		this.data_previsao = data_previsao;
		this.data_devolucao = data_devolucao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getData_emprestimo() {
		return data_emprestimo;
	}

	public void setData_emprestimo(String data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}

	public String getData_previsao() {
		return data_previsao;
	}

	public void setData_previsao(String data_previsao) {
		this.data_previsao = data_previsao;
	}

	public String getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(String data_devolucao) {
		this.data_devolucao = data_devolucao;
	}

}
