package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Transferencia implements Serializable {
	private static final long serialVersionUID =1L;
	private int idTransferencia;
	private String identificacaoTransferencia;
	private Timestamp dtTransferencia;
	private double valorTransferencia;
	private int cpfBeneficiadoTransferencia;
	private int idConta;
	
	public Transferencia(int idTransferencia, String identificacaoTransferencia, Timestamp dtTransferencia, double valorTransferencia, int cpfBeneficiadoTransferencia, int idConta) {
		this.idTransferencia = idTransferencia;
		this.identificacaoTransferencia = identificacaoTransferencia;
		this.dtTransferencia = dtTransferencia;
		this.valorTransferencia = valorTransferencia;
		this.cpfBeneficiadoTransferencia = cpfBeneficiadoTransferencia;
		this.idConta = idConta;
	}
	
	public Transferencia() {}
	
	public int getIdTransferencia() {
		return idTransferencia;
	}
	
	public String getIdentificacaoTransferencia() {
		return identificacaoTransferencia;
	}
	
	public Timestamp getDtTransferencia() {
		return dtTransferencia;
	}
	
	public double getValorTransferencia() {
		return valorTransferencia;
	}
	
	public int getCpfBeneficiadoTransferencia(){
		return cpfBeneficiadoTransferencia;
	}
	
	public int getIdConta() {
		return idConta;
	}
	
	public void setIdTransferencia(int idTransferencia) {
		this.idTransferencia = idTransferencia;
	}
	public void setIdentificacaoTransferencia(String identificacaoTransferencia) {
		this.identificacaoTransferencia = identificacaoTransferencia;
	}
	
	public void setDtTransferencia(Timestamp dtTransferencia) {
		this.dtTransferencia = dtTransferencia;
	}
	
	public void setValorTransferencia(double valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}
	
	public void setCpfBeneficiadoTransferencia(int cpfBeneficiadoTransferencia) {
		this.cpfBeneficiadoTransferencia = cpfBeneficiadoTransferencia;
	}
	
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	
	@Override
	public String toString() {
		return "Transfer�ncia [Id da Transfer�ncia=" + idTransferencia +", Transfer�ncia=" + 
				identificacaoTransferencia + ", Data da Transfer�ncia=" + dtTransferencia +
				", Valor da Transfer�ncia" + valorTransferencia + ", Cpf do Beneficiado=" + cpfBeneficiadoTransferencia +"]";
	}
	
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transferencia other = (Transferencia) obj;
		if (identificacaoTransferencia == null) {
			if(other.identificacaoTransferencia != null)
				return false;
		}else if (!identificacaoTransferencia.equals(other.identificacaoTransferencia))
			return false;
		if (idTransferencia != other.idTransferencia)
			return false;
		if (dtTransferencia != other.dtTransferencia)
			return false;
		if (valorTransferencia == 0) {
			if (other.valorTransferencia != 0)
				return false;
		} else if (valorTransferencia != other.valorTransferencia)
			return false;
		return true;
	}
}
