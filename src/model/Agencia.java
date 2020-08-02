package model;

import java.io.Serializable;

public class Agencia implements Serializable{
	private static final long serialVersionUID = 1L;
	private int idAgencia;
	private String enderecoAgencia;
	private int telefoneAgencia;
	
	public Agencia (int idAgencia, String enderecoAgencia, int telefoneAgencia) {
		this.idAgencia = idAgencia;
		this.enderecoAgencia = enderecoAgencia;
		this.telefoneAgencia = telefoneAgencia;
	}
	
	public Agencia () {}
	
	public int getIdAgencia() {
		return idAgencia;
	}
	
	public String getEnderecoAgencia() {
		return enderecoAgencia;
	}
	
	public int getTelefoneAgencia() {
		return telefoneAgencia;
	}
	
	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}
	
	public void setEnderecoAgencia(String enderecoAgencia) {
		this.enderecoAgencia = enderecoAgencia;
	}
	
	public void setTelefoneAgencia(int telefoneAgencia) {
		this.telefoneAgencia = telefoneAgencia;
	}
	
	@Override
	public String toString() {
		return "Agencia [Id Agencia=" + idAgencia + ", Endereço=" + enderecoAgencia + ", Telefone da Agência=" + telefoneAgencia + "]";
	}
	@Override
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agencia other = (Agencia) obj;
		if(enderecoAgencia == null) {
			if(other.enderecoAgencia != null)
				return false;
		}else if (!enderecoAgencia.equals(other.enderecoAgencia))
			return false;
		if (telefoneAgencia!= other.telefoneAgencia)
			return false;
		if (idAgencia != other.idAgencia)
			return false;
		return true;
	}
}
