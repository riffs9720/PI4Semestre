package model;

import java.io.Serializable;
import java.sql.Date;

public class Deposito implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idDeposito;
	private String identificacaoDeposito;
	private double valorDeposito;
	private Date dtDeposito;
	
	public Deposito (String identificacaoDeposito, double valorDeposito, Date dtDeposito) {
		this.identificacaoDeposito = identificacaoDeposito;
		this.valorDeposito = valorDeposito;
		this.dtDeposito = dtDeposito;
	}
	
	public Deposito () {}
	
	public int getIdDeposito() {
		return idDeposito;
	}
	
	public String getIdentificacaoDeposito() {
		return identificacaoDeposito;
		
	}
	
	public double getValorDeposito() {
		return valorDeposito;
	}
	
	public Date getDtDeposito() {
		return dtDeposito;
	}
	
	public void setIdDeposito(int idDeposito) {
		this.idDeposito = idDeposito;
	}
	
	public void setIdentificacaoDeposito(String identificacaoDeposito) {
		this.identificacaoDeposito = identificacaoDeposito;
	}
	
	public void setValorDeposito(double valorDeposito) {
		this.valorDeposito = valorDeposito;
	}
	
	public void setDtDeposito(Date dtDeposito) {
		this.dtDeposito = dtDeposito;
	}
	
	@Override
	public String toString() {
		return "Deposito [idDeposito=" + idDeposito + ", Identificação do Depósito=" + identificacaoDeposito + ", Valor do Depósito=" + valorDeposito
				+ ", Data do Depósito=" + dtDeposito + "]";
	}
	
	@Override
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deposito other = (Deposito) obj;
		if (identificacaoDeposito == null) {
			if(other.identificacaoDeposito != null)
				return false;
		}else if (!identificacaoDeposito.equals(other.identificacaoDeposito))
			return false;
		if (valorDeposito == 0) {
			if (other.valorDeposito != 0)
				return false;
		} else if (valorDeposito != other.valorDeposito)
			return false;
		if (idDeposito != other.idDeposito)
			return false;
		if (dtDeposito != other.dtDeposito)
			return false;
		return true;
	}
}
