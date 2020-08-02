package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Conta;
import model.Pagamento;
import model.Transacao;
import model.Transferencia;

//Est� classe armazena os metodos do banco.

public class TransacaoDAO {
	public int criar(Transacao transacao) {
		// a linha abaixo indica ao banco quais os campos que ser�o preenchidos.
		String sqlInsert = "INSERT INTO transacao (idTransacao) VALUES (?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setInt(1, transacao.getIdTransacao());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();){
					if(rs.next()) {
						transacao.setIdTransacao(rs.getInt(1));
					}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return transacao.getIdTransacao();
	}
	
	public void atualizar (Transacao transacao) {
		String sqlUpdate = "UPDATE transacao SET idTransacao WHERE idTransacao=?";
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			stm.setInt(1, transacao.getIdTransacao());
			stm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idTransacao) {
		String sqlDelete = "DELETE FROM transacao WHERE idTransacao=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1, idTransacao);
			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Pagamento carregar(int idPagamento) {
		Pagamento pagamento = new Pagamento();
		pagamento.setIdPagamento(idPagamento);
		String sqlSelect = "SELECT idPagamento, identificacaoPagamento, valorPagamento FROM Pagamento WHERE idPagamento=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, pagamento.getIdPagamento());
			try (ResultSet rs = stm.executeQuery();){
				if(rs.next()) {
					pagamento.setIdPagamento(rs.getInt("idPagamento"));
				}else {
					pagamento.setIdPagamento(-1);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pagamento;
	}
	
	public ArrayList<Transacao> listarTransacao(){
		Transacao transacao;
		Pagamento pagamento;
		Transferencia transferencia;
		Conta conta;
		conta = new Conta();
		ArrayList<Transacao> lista = new ArrayList<>();
		String sqlSelect = "SELECT Pagamento.Conta_numeroConta, numeroConta, identificacaoPagamento, valorPagamento, dtPagamento FROM "
				+ "Pagamento INNER JOIN Conta ON Conta.numeroConta = Pagamento.Conta_numeroConta WHERE Conta.numeroConta =?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, conta.getNumeroConta());
			try (ResultSet rs = stm.executeQuery();){
				while(rs.next()) {
					pagamento = new Pagamento();
					transacao = new Transacao();
					conta.setNumeroConta(contAutenticado.getNumeroConta());
					transferencia = new Transferencia();
					pagamento.setIdentificaPagamento(rs.getString("identificacaoPagamento"));
					pagamento.setDtPagamento(rs.getTimestamp("dtPagamento"));
					pagamento.setValorPagamento(rs.getDouble("valorPagamento"));
					transferencia.setIdentificacaoTransferencia(rs.getString("identificacaoTransferencia"));
					transferencia.setDtTransferencia(rs.getTimestamp("dtTransferencia"));
					transferencia.setValorTransferencia(rs.getDouble("valorTransferencia"));
					transacao.setPagamento(pagamento);
					transacao.setTransferencia(transferencia);
					lista.add(transacao);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public ArrayList<Pagamento> listarTransacao(String chave){
		Transacao transacao;
		Pagamento pagamento;
		ArrayList<Pagamento> lista = new ArrayList<>();
		String sqlSelect =  "SELECT identificacaoPagamento, dtPagamento, valorPagamento FROM Pagamento WHERE Pagamento.Conta_numeroConta = 123";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			try (ResultSet rs = stm.executeQuery();){
				while(rs.next()) {
					pagamento = new Pagamento();
					transacao = new Transacao();
					pagamento.setIdentificaPagamento(rs.getString("identificacaoPagamento"));
					pagamento.setDtPagamento(rs.getTimestamp("dtPagamento"));
					pagamento.setValorPagamento(rs.getDouble("valorPagamento"));
					transacao.setPagamento(pagamento);
					lista.add(pagamento);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
}