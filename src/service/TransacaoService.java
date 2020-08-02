package service;

import java.util.ArrayList;

import model.Pagamento;
import model.Transacao;
import dao.TransacaoDAO;

//Est� classe chama o ClienteDAO, ele executa os metodos da classe DAO.

public class TransacaoService {
	TransacaoDAO dao = new TransacaoDAO();
	
	public ArrayList<Pagamento> listarTransacao(String chave) {
		return dao.listarTransacao(chave);
	}
	
	public ArrayList<Transacao> listarTransacao() {
		return dao.listarTransacao();
	}
}