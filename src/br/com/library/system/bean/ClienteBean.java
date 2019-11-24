package br.com.library.system.bean;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import br.com.library.system.model.Cliente;
import br.com.library.system.dao.ClienteDAO;

@ManagedBean(name = "clienteBean")
@SessionScoped
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
	
	public String cadastrar() {
		dao = new ClienteDAO();
		if (dao.save(cliente)) {
			return "/listar-cliente.xhtml?faces-redirect=true";
		} else {
			return "/cadastrar-cliente.xhtml?faces-redirect=true";
		}
	}
	
	public String selecionar() {
//		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		cliente = clientes.getRowData();
//		sessionMap.put("edit", cliente);
		return "/editar-cliente.xhtml?faces-redirect=true";
	}
	
	public String alterar(int id) {
		dao = new ClienteDAO();
		cliente.setId(id);
		if( dao.update(cliente) ) {
			return "/listar-cliente.xhtml?faces-redirect=true";
		} else {
			return "/editar-cliente.xhtml?faces-redirect=true";
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
