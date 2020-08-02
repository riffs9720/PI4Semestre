package service;

import java.util.ArrayList;

import model.Cliente;
import dao.ClienteDAO;

//Está classe chama o ClienteDAO, ele executa os metodos da classe DAO.

public class ClienteService {
	ClienteDAO dao = new ClienteDAO();
	
	public int criar(Cliente cliente) {
		return dao.criar(cliente);
	}
	
	public void atualizar(Cliente cliente) {
		dao.atualizar(cliente);
	}
	
	public void excluir (int idCliente) {
		dao.excluir(idCliente);
	}
	
	public Cliente carregar(int idCliente) {
		return dao.carregar(idCliente);
	}

	public ArrayList<Cliente> listarCliente(String chave) {
		return dao.listarCliente(chave);
	}
}