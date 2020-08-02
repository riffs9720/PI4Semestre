package model;

import java.io.Serializable;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idCliente ;
	private int cpfCliente;
	private int telefoneCliente;
	private String nomeCliente;
	private String enderecoCliente;
	private String dtNascimentoCliente;
	
	public Cliente (int idCliente, int cpfCliente, int telefoneCliente, String dtNascimentoCliente, String nomeCliente, String enderecoCliente) {
		this.idCliente = idCliente;
		this.cpfCliente = cpfCliente;;
		this.telefoneCliente = telefoneCliente;
		this.dtNascimentoCliente = dtNascimentoCliente;
		this.nomeCliente = nomeCliente;
		this.enderecoCliente = enderecoCliente;
		
	}
	
	public Cliente() {
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public int getCpfCliente() {
		return cpfCliente;
	}
	
	public String getDtNascimentoCliente() {
		return dtNascimentoCliente;
	}
	
	public int getTelefoneCliente() {
		return telefoneCliente;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public void setCpfCliente(int cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	public void setDtNascimentoCliente(String dtNascimentoCliente) {
		this.dtNascimentoCliente = dtNascimentoCliente;
	}
	
	public void setTelefoneCliente(int telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + idCliente + ", Nome=" + nomeCliente + ", CPF=" + cpfCliente
				+ ", Data de Nascimento=" + dtNascimentoCliente + "Endere�o=" + enderecoCliente + ", Telefone=" + telefoneCliente + "]";
	}
	
	@Override
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (nomeCliente == null) {
			if(other.nomeCliente != null)
				return false;
		}else if (!nomeCliente.equals(other.nomeCliente))
			return false;
		if (enderecoCliente == null) {
			if(other.enderecoCliente != null)
				return false;
		}else if (!enderecoCliente.equals(other.enderecoCliente))
			return false;
		if (dtNascimentoCliente != other.dtNascimentoCliente)
			return false;
		if (telefoneCliente != other.telefoneCliente)
			return false;
		if (cpfCliente != other.cpfCliente)
			return false;
		if (idCliente != other.idCliente)
			return false;
		return true;
	}
}
