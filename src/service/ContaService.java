package service;

import java.util.ArrayList;

import model.Conta;
//import model.Usuario;
import dao.ContaDAO;
//import dao.UsuarioDAO;

//Está classe chama o DAO, ele executa os metodos da classe DAO.

public class ContaService {
	static ContaDAO dao = new ContaDAO();
	
	public int criar(Conta conta) {
		return dao.criar(conta);
	}
	
	public void atualizar(Conta conta){
		dao.atualizar(conta);
	}
	
	public void excluir (int idConta) {
		dao.excluir(idConta);
	}
	
	public Conta carregar(int idConta) {
		return dao.carregar(idConta);
	}
	
	public Conta carregarConta(int digitoConta) {
		return dao.carregarConta(digitoConta);
	}
	public static Conta autenticacao (Conta conta) {
		return dao.autenticacao(conta);
	}
	public ArrayList<Conta> listarConta(String chave) {
		return dao.listarConta(chave);
	}
	
	/*public boolean validar(Conta conta){
		ContaDAO dao = new ContaDAO();
		return dao.validar(conta);
	}*/
}