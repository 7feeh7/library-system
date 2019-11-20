package br.com.library.system.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.library.system.model.Cliente;
import br.com.library.system.dao.ClienteDAO;

@ManagedBean(name = "clienteBean")
public class ClienteBean {
	
	private ClienteDAO dao = null;
	private Cliente cliente = new Cliente();
	private DataModel<Cliente> clientes;
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setClientes(DataModel<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void gravar() {
		dao = new ClienteDAO();
		if (dao.save(cliente)) {
			System.out.println("Salvo com sucesso!");
		} else {
			System.out.println("Erro ao salvar");
		}
	}
	
	public DataModel<Cliente>getClientes(){
		dao = new ClienteDAO();
		List<Cliente> clienteList = dao.findAll();
		clientes = new ListDataModel<Cliente>(clienteList);
		return clientes;
	}
	

	

	
}
