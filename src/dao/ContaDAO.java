package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Agencia;
import model.Conta;
import service.AgenciaService;
import service.ClienteService;
import service.TipoContaService;

//Est� classe armazena os m�todos do banco .

public class ContaDAO {
	public int criar(Conta conta) {
		// a linha abaixo indica ao banco quais os campos que ser�o preenchidos.
		String sqlInsert = "INSERT INTO Conta (numeroConta, senhaConta, dtAberturaConta, saldoConta, numeroToken) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setInt(1, conta.getNumeroConta());
			stm.setInt(2, conta.getSenhaConta());
			stm.setTimestamp(3, conta.getDtAbertura());
			stm.setDouble(4, conta.getSaldoConta());
			stm.setInt(5, conta.getNumeroConta());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();){
					if(rs.next()) {
						conta.setNumeroConta(rs.getInt(1));
					}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return conta.getNumeroConta();
	}
	
	public void atualizar (Conta conta) {
		String sqlUpdate = "UPDATE Conta SET saldoConta=? WHERE numeroConta=?";
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			stm.setDouble(1, conta.getSaldoConta());
			stm.setInt(2, conta.getNumeroConta());			
			stm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int numeroConta) {
		String sqlDelete = "DELETE FROM Conta WHERE numeroConta=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1, numeroConta);
			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Conta carregar(int numeroConta) {
		Conta conta = new Conta();
		conta.setNumeroConta(numeroConta);
		String sqlSelect = "SELECT numeroConta, senhaConta, dtAberturaConta, saldoConta FROM Conta WHERE conta.numeroConta=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, conta.getNumeroConta());
			try (ResultSet rs = stm.executeQuery();){
				if(rs.next()) {
					conta.setNumeroConta(rs.getInt("numeroConta"));
					conta.setSenhaConta(rs.getInt("senhaConta"));
					conta.setDtAbertura(rs.getTimestamp("dtAberturaConta"));
					conta.setSaldoConta(rs.getDouble("saldoConta"));
				}else {
					conta.setNumeroConta(-1);
					conta.setDtAbertura(null);
					conta.setSaldoConta(-1);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return conta;
	}
	
	public Conta carregarConta(int numeroConta) {
		Conta conta = new Conta();
		conta.setNumeroConta(numeroConta);
		String sqlSelect = "SELECT numeroConta, senhaConta, dtAberturaConta, saldoConta, Agencia_idAgencia, TipoConta_idTipoConta, Cliente_idCliente FROM Conta WHERE numeroConta=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, conta.getNumeroConta());
			try (ResultSet rs = stm.executeQuery();){
				if(rs.next()) {
					conta.setNumeroConta(rs.getInt("NumeroConta"));
					conta.setSenhaConta(rs.getInt("senhaConta"));
					conta.setDtAbertura(rs.getTimestamp("dtAberturaConta"));
					conta.setSaldoConta(rs.getDouble("saldoConta"));
					TipoContaService tipoConta = new TipoContaService();
					AgenciaService agencia = new AgenciaService();
					ClienteService cliente = new ClienteService();
					conta.setCliente(cliente.carregar(rs.getInt("Cliente_idCliente")));
					conta.setTipoConta(tipoConta.carregar(rs.getInt("TipoConta_idTipoConta")));
					conta.setAgencia(agencia.carregar(rs.getInt("Agencia_idAgencia")));
					
				}else {
					conta.setNumeroConta(-1);
					conta.setDtAbertura(null);
					conta.setSaldoConta(-1);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return conta;
	}
	
	public ArrayList<Conta> listarConta(String chave){
		Conta conta;
		ArrayList<Conta> lista = new ArrayList<>();
		String sqlSelect = "SELECT numeroConta, senhaConta, dtAberturaConta, saldoConta FROM Conta WHERE upper(numeroConta) like";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();){
				while(rs.next()) {
					conta = new Conta();
					conta.setNumeroConta(rs.getInt("numeroConta"));
					conta.setSenhaConta(rs.getInt("senhaConta"));
					conta.setDtAbertura(rs.getTimestamp("dtAberturaConta"));
					conta.setSaldoConta(rs.getDouble("nomeAgencia"));
					lista.add(conta);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public Conta autenticacao(Conta conta) {
		Conta contRetorno = null;
		Agencia agencia = new Agencia();
		String sqlSelect = "SELECT numeroConta, senhaConta, dtAberturaConta, saldoConta, Cliente_idCliente, Agencia_idAgencia, TipoConta_idTipoConta, numeroToken FROM Conta WHERE numeroConta= ? and senhaConta= ? and Agencia_idAgencia = ? and numeroToken=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, conta.getNumeroConta());
			stm.setInt(2, conta.getSenhaConta());
			stm.setInt(3, conta.getAgencia().getIdAgencia());
			stm.setInt(4, conta.getNumeroToken());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					contRetorno = new Conta();
					contRetorno.setNumeroConta(rs.getInt("numeroConta"));
					contRetorno.setDtAbertura(rs.getTimestamp("dtAberturaConta"));
					contRetorno.setSenhaConta(rs.getInt("senhaConta"));
					contRetorno.setnumeroToken(rs.getInt("numeroToken"));
					agencia.setIdAgencia(rs.getInt("Agencia_idAgencia"));
					contRetorno.setAgencia(agencia);
					contRetorno.setSaldoConta(rs.getInt("saldoConta"));
					int clienteId = rs.getInt("Cliente_idCliente");
					ClienteService clienteService = new ClienteService();
					contRetorno.setCliente(clienteService.carregar(clienteId));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return contRetorno;
	}
}

