package model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Pagamento implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idPagamento;
	private String identificaPagamento;
	private double valorPagamento;
	private Date agendarPagamento;
	private Date dtVencimento;
	private Timestamp dtPagamento;
	private Conta conta;
	private Agencia agencia;
	
	public Pagamento (Agencia agencia, Conta conta, int idPagamento, String identificaPagamento, double valorPagamento, Date agendarPagamento, Date dtVencimento, Timestamp dtPagamento) {
		this.idPagamento = idPagamento;
		this.identificaPagamento = identificaPagamento;
		this.valorPagamento = valorPagamento;
		this.agendarPagamento = agendarPagamento;
		this.dtVencimento = dtVencimento;
		this.dtPagamento = dtPagamento;
		this.conta = conta;
		this.agencia = agencia;
	}
	
	public Pagamento () {}
	
	public int getIdPagamento() {
		return idPagamento;
	}
	
	public String getIdentificaPagamento() {
		return identificaPagamento;
	}
	
	public double getValorPagamento() {
		return valorPagamento;
	}

	public Date getAgendarPagamento() {
		return agendarPagamento;
	}
	
	public Date getDtVencimento() {
		return dtVencimento;
	}
	
	public Timestamp getDtPagamento() {
		return dtPagamento;
	}
	
	public Conta getConta() {
		return conta;
	}
	
	public Agencia getAgencia() {
		return agencia;
	}

	public void setIdPagamento(int idPagamento) {
	this.idPagamento = idPagamento;
	}
	
	public void setIdentificaPagamento(String identificaPagamento) {
		this.identificaPagamento = identificaPagamento;
	}
	
	public void setValorPagamento(double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	
	public void setAgendarPagamento(Date agendarPagamento) {
		this.agendarPagamento = agendarPagamento;
	}
	
	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}
	
	public void setDtPagamento(Timestamp dtPagamento2) {
		this.dtPagamento = dtPagamento2;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
	@Override
	public String toString() {
		return "Pagamento [idPagamento=" + idPagamento + ", Identificação do Pagamento=" + identificaPagamento + ", Valor do Pagamento=" + valorPagamento
				+ "Data de Vencimento=" + dtVencimento + ", Agendar Pagamento=" + agendarPagamento + ", Data do Pagamento=" + dtPagamento + "]";
	}
	
	@Override
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (identificaPagamento == null) {
			if(other.identificaPagamento != null)
				return false;
		}else if (!identificaPagamento.equals(other.identificaPagamento))
			return false;
		if (valorPagamento == 0) {
			if (other.valorPagamento != 0)
				return false;
		} else if (valorPagamento != other.valorPagamento)
			return false;
		if (idPagamento != other.idPagamento)
			return false;
		if (dtPagamento != other.dtPagamento)
			return false;
		return true;
	}

}