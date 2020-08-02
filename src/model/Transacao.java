package model;

import java.io.Serializable;

public class Transacao implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idTransacao;
	Conta conta;
	Pagamento pagamento;
	Deposito deposito;
	Transferencia transferencia;
	
	public Transacao (int idTransacao, Conta conta, Pagamento pagamento, Deposito deposito, Transferencia transferencia) {
		super();
		this.idTransacao = idTransacao;
		this.conta = conta;
		this.pagamento = pagamento;
		this.transferencia = transferencia;
	}
	
	public Transacao() {
		
	}
	
	public int getIdTransacao() {
		return idTransacao;
	}
	
	public Conta getConta() {
		return conta;
	}
	
	public Pagamento getPagamento() {
		return pagamento;
	}
	
	public Deposito getDeposito() {
		return deposito;
	}
	
	public Transferencia getTransferencia(){
		return transferencia;
	}
	
	public void setIdTransacao(int idTransacao) {
		this.idTransacao = idTransacao;
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}
	
	public void setTransferencia(Transferencia transferencia) {
		this.transferencia = transferencia;
	}
	@Override
	public String toString() {
		return "Transaçao [Id da Transaçao=" + idTransacao + ", Conta=" + conta + ", Pagamento=" + pagamento + ", Depósito=" + deposito + ", Transferência=" + transferencia + "]";
	}
	
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		if (idTransacao != other.idTransacao)
			return false;
		return true;
	}
}
