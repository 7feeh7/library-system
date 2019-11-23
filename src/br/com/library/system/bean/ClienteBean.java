package br.com.library.system.bean;

import java.sql.Connection;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import br.com.library.system.model.Cliente;
import br.com.library.system.dao.ClienteDAO;

@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean{
	
	private ClienteDAO dao = null;
	private Cliente cliente = new Cliente();
	private DataModel<Cliente> clientes;
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setClientes(DataModel<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void cadastrar() {
		dao = new ClienteDAO();
		if (dao.save(cliente)) {
			System.out.println("Salvo com sucesso!");
		} else {
			System.out.println("Erro ao salvar");
		}
	}
	
	public void selecionar() {
		cliente = clientes.getRowData();
	}
	
	public void alterar(int id) {
		dao = new ClienteDAO();
		cliente.setId(id);
		if(dao.update(cliente)) {
			System.out.println("Alterado com sucesso!");
		} else {
			System.out.println("Erro ao alterar");
		}
	}
	
	public DataModel<Cliente>getClientes(){
		dao = new ClienteDAO();
		List<Cliente> clienteList = dao.findAll();
		clientes = new ListDataModel<Cliente>(clienteList);
		return clientes;
	}
	
	public void excluir(int id) {
		try {
			cliente.setId(id);
			dao = new ClienteDAO();
			if(dao.delete(cliente)) {
				System.out.println("Deletado com sucesso");
			} else {
				System.out.println("Erro ao deletar");
			}
		} catch (Exception ex) {
			System.out.println("Erro: " + ex);
		}
	}
	
	public String editar(int id) {
		dao = new ClienteDAO();
		return dao.edit(id);
	}

}
