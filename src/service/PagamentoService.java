package service;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Agencia;
import model.Conta;
import model.Pagamento;
import dao.PagamentoDAO;

//Est� classe chama o ClienteDAO, ele executa os metodos da classe DAO.

public class PagamentoService {
	PagamentoDAO dao = new PagamentoDAO();
	
	public int criar(Pagamento pagamento, Conta conta, Agencia agencia){
		return dao.criar(pagamento, conta, agencia);
	}
	
	public void atualizar(Pagamento pagamento) {
		dao.atualizar(pagamento);
	}
	
	public void excluir (int idPagamento) {
		dao.excluir(idPagamento);
	}
	
	public Pagamento carregar(int idPagamento) {
		return dao.carregar(idPagamento);
	}
	
	public ArrayList<Pagamento> listarPagamento(String chave) {
		return dao.listarPagamento(chave);
	}
	
	public double fazPagamento(Conta conta, Pagamento pagamento, Agencia agencia) {
		if(conta.getSaldoConta() >= pagamento.getValorPagamento()) {
			conta.setSaldoConta(conta.getSaldoConta() - pagamento.getValorPagamento());
		this.criar(pagamento, conta, agencia);
		ContaService service = new ContaService();
		service.atualizar(conta);
		}else {
			JOptionPane.showMessageDialog(null, "Você não tem saldo suficiente para realizar esta transação!");
		}
		return conta.getSaldoConta();
	}
}