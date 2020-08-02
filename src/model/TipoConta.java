package model;

import java.io.Serializable;

public class TipoConta extends Conta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String descricaoTipoConta;
	private int idTipoConta;
	
	public TipoConta (String descricaoTipoConta, int idTipoConta){
		this.descricaoTipoConta = descricaoTipoConta;
		this.idTipoConta = idTipoConta;
	}
	
	public TipoConta( ) {}

	public String getDescricaoTipoConta() {
		return this.descricaoTipoConta;
	}
	
	public int getIdTipoConta() {
		return idTipoConta;
	}
	
	public void setDescricaoTipoConta(String descricaoTipoConta) {
		this.descricaoTipoConta = descricaoTipoConta;
	}
	
	public void setIdTipoConta(int idTipoConta) {
		this.idTipoConta = idTipoConta;
	}
	
	@Override
	public String toString() {
		return "Tipo de Conta [Id Tipo de Conta=" + idTipoConta + " Tipo de Conta=" + descricaoTipoConta + "]";
	}
	
	@Override
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoConta other = (TipoConta) obj;
		if (descricaoTipoConta == null) {
			if(other.descricaoTipoConta != null)
				return false;
		}else if (!descricaoTipoConta.equals(other.descricaoTipoConta))
			return false;
		if (idTipoConta != other.idTipoConta)
			return false;
		return true;
	}
}
