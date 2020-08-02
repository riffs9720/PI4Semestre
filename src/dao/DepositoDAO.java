package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Deposito;

//Est� classe armazena os metodos do banco.

public class DepositoDAO {
	public int criar(Deposito deposito) {
		// a linha abaixo indica ao banco quais os campos que ser�o preenchidos.
		String sqlInsert = "INSERT INTO Deposito (identificacaoDeposito, valorDeposito, dtDeposito) VALUES (?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setString(1, deposito.getIdentificacaoDeposito());
			stm.setDouble(2, deposito.getValorDeposito());
			stm.setDate(3, deposito.getDtDeposito());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();){
					if(rs.next()) {
						deposito.setIdDeposito(rs.getInt(1));
					}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return deposito.getIdDeposito();
	}
	
	public void atualizar (Deposito deposito) {
		String sqlUpdate = "UPDATE Deposito SET identificacaoDeposito=?, valorDeposito=?, dtDeposito WHERE idDeposito=?";
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			stm.setString(1, deposito.getIdentificacaoDeposito());
			stm.setDouble(2, deposito.getValorDeposito());
			stm.setDate(3, deposito.getDtDeposito());
			stm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idDeposito) {
		String sqlDelete = "DELETE FROM deposito WHERE idDeposito=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1, idDeposito);
			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Deposito carregar(int idDeposito) {
		Deposito deposito = new Deposito();
		deposito.setIdDeposito(idDeposito);
		String sqlSelect = "SELECT identificacaoDeposito, valorDeposito, dtDeposito FROM deposito WHERE deposito.idDeposito=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, deposito.getIdDeposito());
			try (ResultSet rs = stm.executeQuery();){
				if(rs.next()) {
					deposito.setIdentificacaoDeposito(rs.getString("identificacaoDeposito"));
					deposito.setValorDeposito(rs.getDouble("valorDeposito"));
					deposito.setDtDeposito(rs.getDate("dtDeposito"));
				}else {
					deposito.setIdDeposito(-1);
					deposito.setIdentificacaoDeposito(null);
					deposito.setValorDeposito(0L);
					deposito.setDtDeposito(null);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return deposito;
	}
	
	public ArrayList<Deposito> listarDeposito(String chave){
		Deposito deposito;
		ArrayList<Deposito> lista = new ArrayList<>();
		String sqlSelect = "SELECT idDeposito, identificacaoDeposito, valorDeposito, dtDeposito FROM deposito WHERE upper(identificacaoDeposito) like";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();){
				while(rs.next()) {
					deposito = new Deposito();
					deposito.setIdDeposito(rs.getInt("idDeposito"));
					deposito.setIdentificacaoDeposito(rs.getString("identificacaoDeposito"));
					deposito.setValorDeposito(rs.getDouble("valorDeposito"));
					deposito.setDtDeposito(rs.getDate("dtDeposito"));
					lista.add(deposito);
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