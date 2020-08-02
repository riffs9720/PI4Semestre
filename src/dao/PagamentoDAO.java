package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Agencia;
import model.Conta;
import model.Pagamento;

//Est� classe armazena os metodos do banco.

public class PagamentoDAO {
	public int criar(Pagamento pagamento, Conta conta, Agencia agencia) {
		// a linha abaixo indica ao banco quais os campos que ser�o preenchidos.
		String sqlInsert = "INSERT INTO Pagamento (identificacaoPagamento, valorPagamento, dtPagamento, Conta_numeroConta, Conta_Agencia_idAgencia) values (?, ?, ?, ?, ?)";
		
		try {
			Connection conn = ConnectionFactory.obtemConexao();

			try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {				
				stm.setString(1, pagamento.getIdentificaPagamento());				
				stm.setDouble(2, pagamento.getValorPagamento());
				stm.setTimestamp(3, pagamento.getDtPagamento());
				stm.setInt(4, conta.getNumeroConta());
				stm.setInt(5, agencia.getIdAgencia());
				stm.execute();
				
				String sqlQuery = "SELECT LAST_INSERT_ID()";
				
				try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();){
						if(rs.next()) {
							System.out.println(rs.toString());
							pagamento.setIdPagamento(rs.getInt(1));
						}else {
							pagamento.setIdPagamento(-1);
						}
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}catch (SQLException e1) {
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		}catch (SQLException e2) {
			e2.printStackTrace();
		}
		return pagamento.getIdPagamento();
	}
	
	public void atualizar (Pagamento pagamento) {
		String sqlUpdate = "UPDATE Pagamento SET identificaoPagamento=?, valorPagamento=?, dtPagamento=? WHERE idPagamento=?";
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			stm.setString(1, pagamento.getIdentificaPagamento());
			stm.setDouble(2, pagamento.getValorPagamento());
			stm.setDate(3, pagamento.getDtVencimento());
			stm.setTimestamp(4, pagamento.getDtPagamento());
			stm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idPagamento) {
		String sqlDelete = "DELETE FROM Pagamento WHERE idPagamento=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1, idPagamento);
			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Pagamento carregar(int idPagamento) {
		Pagamento pagamento = new Pagamento();
		pagamento.setIdPagamento(idPagamento);
		String sqlSelect = "SELECT identificaoPagamento, valorPagamento, dtPagamento FROM Pagamento WHERE idPagamento=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, pagamento.getIdPagamento());
			try (ResultSet rs = stm.executeQuery();){
				if(rs.next()) {
					pagamento.setIdentificaPagamento(rs.getString("identificaoPagamento"));
					pagamento.setValorPagamento(rs.getDouble("valorPagamento"));
					pagamento.setDtPagamento(rs.getTimestamp("dtPagamento"));
				}else {
					pagamento.setIdPagamento(-1);
					pagamento.setIdentificaPagamento(null);
					pagamento.setValorPagamento(0L);
					pagamento.setDtPagamento(null);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pagamento;
	}
	
	public ArrayList<Pagamento> listarPagamento(String chave){
		Pagamento pagamento;
		ArrayList<Pagamento> lista = new ArrayList<>();
		String sqlSelect = "SELECT idPagamento, identificaoPagamento, valorPagamento, dtPagamento FROM Pagamento WHERE upper(identificaPagamento) like";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();){
				while(rs.next()) {
					pagamento = new Pagamento();
					pagamento.setIdPagamento(rs.getInt("idPagamento"));
					pagamento.setIdentificaPagamento(rs.getString("identificaoPagamento"));
					pagamento.setValorPagamento(rs.getDouble("valorPagamento"));
					pagamento.setDtPagamento(rs.getTimestamp("dtPagamento"));
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