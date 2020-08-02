package service;

import java.util.ArrayList;

import model.TipoConta;
import dao.TipoContaDAO;

//Está classe chama o ClienteDAO, ele executa os metodos da classe DAO.

public class TipoContaService {
	TipoContaDAO dao = new TipoContaDAO();
	
	public int criar(TipoConta tipoConta) {
		return dao.criar(tipoConta);
	}
	
	public void atualizar(TipoConta tipoConta) {
		dao.atualizar(tipoConta);
	}
	
	public void excluir (int idTipoConta) {
		dao.excluir(idTipoConta);
	}
	
	public TipoConta carregar(int idTipoConta) {
		return dao.carregar(idTipoConta);
	}
	public ArrayList<TipoConta> listarTipoConta(String chave) {
		return dao.listarTipoConta(chave);
	}
}