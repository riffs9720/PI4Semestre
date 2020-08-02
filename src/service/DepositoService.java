package service;

import java.util.ArrayList;

import model.Deposito;
import dao.DepositoDAO;

//Está classe chama o ClienteDAO, ele executa os metodos da classe DAO.

public class DepositoService {
	DepositoDAO dao = new DepositoDAO();
	
	public int criar(Deposito deposito) {
		return dao.criar(deposito);
	}
	
	public void atualizar(Deposito deposito) {
		dao.atualizar(deposito);
	}
	
	public void excluir (int idDeposito) {
		dao.excluir(idDeposito);
	}
	
	public Deposito carregar(int idDeposito) {
		return dao.carregar(idDeposito);
	}
	
	public ArrayList<Deposito> listarDeposito(String chave) {
		return dao.listarDeposito(chave);
	}
}