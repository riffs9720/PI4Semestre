package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Transferencia;

public class TransferenciaDAO {
	
	public boolean criar(Transferencia transferencia) {
		String sqlInsert = "INSERT INTO Transferencia (identificacaoTransferencia, dtTransferencia, cpfBeneficiadoTransferencia, valorTransferencia, Conta_numeroConta) VALUES (?, ?, ?, ?, ?)";
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			try (PreparedStatement stm = conn.prepareStatement(sqlInsert);){
				stm.setString(1, transferencia.getIdentificacaoTransferencia());
				stm.setTimestamp(2, transferencia.getDtTransferencia());
				stm.setInt(3, transferencia.getCpfBeneficiadoTransferencia());
				stm.setDouble(4, transferencia.getValorTransferencia());
				stm.setInt(5, transferencia.getIdConta());
				stm.execute();
				String sqlQuery = "SELECT LAST_INSERT_ID()";
				try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();){
					if(rs.next()) {
						transferencia.setIdTransferencia(rs.getInt(1));
					return true;
				}else {
					return false;
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
		return false;
	}
	
	public void atualizar (Transferencia transferencia) {
		String sqlUpdate = "UPDATE transferencia SET identificacaoTransferencia=?, dtTransferencia=?, valorTransferencia=? WHERE idTransferencia=?";
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			stm.setString(1, transferencia.getIdentificacaoTransferencia());
			stm.setTimestamp(2, transferencia.getDtTransferencia());
			stm.setDouble(3, transferencia.getValorTransferencia());
			stm.execute();
			System.out.println("Atualizar " + transferencia.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idTransferencia) {
		String sqlDelete = "DELETE FROM transferencia WHERE idTransferencia=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1, idTransferencia);
			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Transferencia carregar(int idTransferencia) {
		Transferencia transferencia = new Transferencia();
		transferencia.setIdTransferencia(idTransferencia);
		String sqlSelect = "SELECT transferencia FROM identificacaoTransferencia, dtTransferencia, valorTransferencia WHERE transferencia.idTransferencia=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, transferencia.getIdTransferencia());
			System.out.println("carregar " + transferencia.toString());
			try (ResultSet rs = stm.executeQuery();){
				if(rs.next()) {
					transferencia.setIdentificacaoTransferencia(rs.getString("identificacaoTransferencia"));
					transferencia.setDtTransferencia(rs.getTimestamp("dtTransferencia"));
					transferencia.setValorTransferencia(rs.getDouble("idTransferencia"));
				}else {
					transferencia.setIdTransferencia(-1);
					transferencia.setIdentificacaoTransferencia(null);
					transferencia.setDtTransferencia(null);
					transferencia.setValorTransferencia(0L);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch(SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return transferencia;
	}
	
	public Transferencia carregarTransferencia(int digitoConta) {
		Transferencia transferencia = new Transferencia();
		transferencia.setIdTransferencia(digitoConta);
		String sqlSelect = "SELECT transferencia FROM identificacaoTransferencia, dtTransferencia, valorTransferencia WHERE transferencia.digitoConta=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, transferencia.getIdTransferencia());
			try (ResultSet rs = stm.executeQuery();){
				if(rs.next()) {
					transferencia.setIdentificacaoTransferencia(rs.getString("identificacaoTransferencia"));
					transferencia.setDtTransferencia(rs.getTimestamp("dtTransferencia"));
					transferencia.setValorTransferencia(rs.getDouble("idTransferencia"));
				}else {
					transferencia.setIdTransferencia(-1);
					transferencia.setIdentificacaoTransferencia(null);
					transferencia.setDtTransferencia(null);
					transferencia.setValorTransferencia(0L);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch(SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return transferencia;
	}
	
	public ArrayList<Transferencia> listarTransferencia(String chave){
		Transferencia transferencia;
		ArrayList<Transferencia> lista = new ArrayList<>();
		String sqlSelect = "SELECT identificacaoTransferencia, dtTransferencia, valorTransferencia FROM transferencia WHERE upper(identificaTransferencia) like";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();){
				while(rs.next()) {
					transferencia = new Transferencia();
					transferencia.setIdTransferencia(rs.getInt("idTransferencia"));
					transferencia.setDtTransferencia(rs.getTimestamp("dtTransferencia"));
					lista.add(transferencia);
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
