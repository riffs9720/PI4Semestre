package model;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
 
public class Conta implements Serializable {
	private static final long serialVersionUID = 1L;
	private int numeroConta;
	private int senhaConta;
	private Timestamp dtAbertura;
	private double saldoConta;
	private int numeroToken;
	private Agencia agencia;
	private TipoConta tipoConta;
	private Cliente cliente;
	
	public Conta (Cliente cliente , Agencia agencia, TipoConta tipoConta, int numeroConta, int digitoConta, int senhaConta, Timestamp dtAbertura, int saldoConta, int numeroToken) {
		super();
		this.numeroConta = numeroConta;
		this.senhaConta = senhaConta;
		this.dtAbertura = dtAbertura;
		this.saldoConta = saldoConta;
		this.numeroToken = numeroToken;
		this.cliente = cliente;
		this.tipoConta = tipoConta;
		this.agencia = agencia;
	}
	
	public Conta () {
	}
	public Agencia getAgencia() {
		return agencia;
	}
	
	public TipoConta getTipoConta() {
		return tipoConta;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}

	public int getSenhaConta() {
		return senhaConta;
	}
	
	public Timestamp getDtAbertura() {
		return dtAbertura;
	}
	
	public double getSaldoConta() {
		return saldoConta;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public int getNumeroToken(){
		return numeroToken;
	}
	
	public String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public void setSenhaConta(int senhaConta) {
		this.senhaConta = senhaConta;
	}
	
	public void setDtAbertura(Timestamp dtAbertura) {
		this.dtAbertura = dtAbertura;
	}
	
	public void setSaldoConta(double saldoConta) {
		this.saldoConta = saldoConta;
	}
	
	public void setnumeroToken(int numeroToken) {
		this.numeroToken = numeroToken;
	}
	
	@Override
	public String toString() {
		return "Conta [Numero da Conta=" + numeroConta + ", Agencia=" + agencia + ", Senha da Conta=" + senhaConta + ", Data da Abertura de Conta=" + dtAbertura + "Saldo da Conta=" + saldoConta + "Token=" + numeroToken + "]";
	}
	
	public boolean equals (Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (numeroConta != other.numeroConta)
			return false;
		if (agencia != other.agencia)
			return false;
		if (senhaConta != other.senhaConta)
			return false;
		if (dtAbertura != other.dtAbertura)
			return false;
		if (numeroToken != other.numeroToken)
			return false;
		if (saldoConta == 0) {
			if (other.saldoConta != 0)
				return false;
		} else if (saldoConta != other.saldoConta)
			return false;
		return true;
	}

}
