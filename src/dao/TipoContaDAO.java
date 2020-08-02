package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TipoConta;

public class TipoContaDAO {
	
	public int criar(TipoConta tipoConta) {
		String sqlInsert = "INSERT INTO tipoConta (tipoConta) VALUES (?)";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setString(1, tipoConta.getDescricaoTipoConta());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm.executeQuery();){
				if(rs.next()) {
					tipoConta.setIdTipoConta(rs.getInt(1));
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tipoConta.getIdTipoConta();
	}
	
	public void atualizar (TipoConta tipoConta) {
		String sqlUpdate = "UPDATE tipoConta set tipoConta=? WHERE idTipoConta=?";
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			stm.setString(1, tipoConta.getDescricaoTipoConta());
			stm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idTipoConta) {
		String sqlDelete = "DELETE FROM tipoConta WHERE idTipoConta=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1, idTipoConta);
			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public TipoConta carregar(int idTipoConta) {
		TipoConta tipoConta = new TipoConta();
		tipoConta.setIdTipoConta(idTipoConta);
		String sqlSelect = "SELECT tipoConta FROM tipoConta WHERE TipoConta.idTipoConta=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, tipoConta.getIdTipoConta());
			try (ResultSet rs = stm.executeQuery();){
				if(rs.next()) {
					tipoConta.setDescricaoTipoConta(rs.getString("tipoConta"));			
				}else {
					tipoConta.setIdTipoConta(-1);
					tipoConta.setTipoConta(null);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch(SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return tipoConta;
	}
	
	public ArrayList<TipoConta> listarTipoConta(String chave){
		TipoConta tipoConta;
		ArrayList<TipoConta> lista = new ArrayList<>();
		String sqlSelect = "SELECT tipoConta FROM tipoConta WHERE upper(tipoConta) like";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();){
				while(rs.next()) {
					tipoConta = new TipoConta();
					tipoConta.setIdTipoConta(rs.getInt("idTipoConta"));
					tipoConta.setDescricaoTipoConta(rs.getString("tipoConta"));
					lista.add(tipoConta);
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
