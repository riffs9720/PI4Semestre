package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Agencia;

//Est� classe armazena os metodos do banco.

public class AgenciaDAO {
	public int criar(Agencia agencia) {
		// a linha abaixo indica ao banco quais os campos que serão preenchidos.
		String sqlInsert = "INSERT INTO Agencia (enderecoAgencia, telefoneAgencia) VALUES (?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setString(1, agencia.getEnderecoAgencia());
			stm.setInt(2, agencia.getTelefoneAgencia());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();){
					if(rs.next()) {
						agencia.setIdAgencia(rs.getInt(1));
					}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return agencia.getIdAgencia();
	}
	
	public void atualizar (Agencia agencia) {
		String sqlUpdate = "UPDATE Agencia SET enderecoAgencia=? WHERE idAgencia=?";
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			stm.setString(1, agencia.getEnderecoAgencia());
			stm.setInt(2, agencia.getIdAgencia());
			stm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idAgencia) {
		String sqlDelete = "DELETE FROM Agencia WHERE idAgencia=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1, idAgencia);
			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Agencia carregar(int idAgencia) {
		Agencia agencia = new Agencia();
		agencia.setIdAgencia(idAgencia);
		String sqlSelect = "SELECT enderecoAgencia, telefoneAgencia FROM Agencia WHERE Agencia.idAgencia=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, agencia.getIdAgencia());
			try (ResultSet rs = stm.executeQuery();){
				if(rs.next()) {
					agencia.setEnderecoAgencia(rs.getString("enderecoAgencia"));
					agencia.setTelefoneAgencia(rs.getInt("telefoneAgencia"));
				}else {
					agencia.setIdAgencia(-1);
					agencia.setEnderecoAgencia(null);
					agencia.setTelefoneAgencia(-1);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return agencia;
	}
	
	public boolean validar(Agencia agencia) {
		String sqlSelect = "SELECT idAgencia FROM Agencia "
				+ "WHERE username = ?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, agencia.getIdAgencia());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Agencia> listarAgencia(String chave){
		Agencia agencia;
		ArrayList<Agencia> lista = new ArrayList<>();
		String sqlSelect = "SELECT idAgencia, enderecoAgencia, telefoneAgencia FROM Agencia WHERE upper(enderecoAgencia) like";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();){
				while(rs.next()) {
					agencia = new Agencia();
					agencia.setIdAgencia(rs.getInt("idAgencia"));
					agencia.setEnderecoAgencia(rs.getString("enderecoAgencia"));
					agencia.setTelefoneAgencia(rs.getInt("telefoneAgencia"));
					lista.add(agencia);
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