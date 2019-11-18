package br.com.library.system.bean;

import javax.faces.bean.ManagedBean;
import br.com.library.model.Cliente;
import br.com.library.system.dao.ClienteDAO;

@ManagedBean(name = "clienteBean")
public class ClienteBean {
	
	private Cliente cliente = new Cliente();
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void gravar() {
		ClienteDAO dao = new ClienteDAO();
		if (dao.save(cliente)) {
			System.out.println("Salvo com sucesso!");
		} else {
			System.out.println("Erro ao salvar");
		}
	}
	

	
}
