package service;

import java.util.ArrayList;

import model.Conta;
import model.Transferencia;
import dao.TransferenciaDAO;

//Est� classe chama o ClienteDAO, ele executa os metodos da classe DAO.

public class TransferenciaService {
	TransferenciaDAO dao = new TransferenciaDAO();
	
	public boolean criar(Transferencia transferencia) {
		return dao.criar(transferencia);
	}
	
	public void atualizar(Transferencia transferencia) {
		dao.atualizar(transferencia);
	}
	
	public void excluir (int idTransferencia) {
		dao.excluir(idTransferencia);
	}
	
	public Transferencia carregar(int idTransferencia) {
		return dao.carregar(idTransferencia);
	}
	
	public ArrayList<Transferencia> listarTransferencia(String chave) {
		return dao.listarTransferencia(chave);
	}
	
	public boolean fazTransferencia (Conta contaOrigem, Conta contaDestino, Transferencia transferencia) {
		contaOrigem.setSaldoConta(contaOrigem.getSaldoConta() - transferencia.getValorTransferencia());
		//contaDestino.setSaldoConta(transferencia.getValorTransferencia());
		transferencia.setIdConta(contaOrigem.getNumeroConta());
		if (this.criar(transferencia)) {
			ContaService contaService = new ContaService();
			contaService.atualizar(contaOrigem);
			contaService.atualizar(contaDestino);
			return true;
		}else {
			return false;
		}
	}
}