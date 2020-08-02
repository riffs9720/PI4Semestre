package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;
//import model.Usuario;

//Est� classe armazena os metodos do banco.

public class ClienteDAO {
	public int criar(Cliente cliente) {
		// a linha abaixo indica ao banco quais os campos que ser�o preenchidos.
		String sqlInsert = "INSERT INTO Cliente (nomeCliente, cpfCliente, enderecoCliente, dtNascimentoCLiente, telefoneCliente) VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setString(1, cliente.getNomeCliente());
			stm.setInt(2, cliente.getCpfCliente());
			stm.setString(3, cliente.getEnderecoCliente());
			stm.setString(4, cliente.getDtNascimentoCliente());
			stm.setInt(5, cliente.getTelefoneCliente());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();){
					if(rs.next()) {
						cliente.setIdCliente(rs.getInt(1));
					}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente.getIdCliente();
	}
	
	public void atualizar (Cliente cliente) {
		String sqlUpdate = "UPDATE Cliente SET nomeCliente=?, cpfCliente=?, enderecoCliente=?, dtNascimentoCliente=?, telefoneCliente=? WHERE idCliente=?";
		try(Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			stm.setString(1, cliente.getNomeCliente());
			stm.setInt(2, cliente.getCpfCliente());
			stm.setString(3, cliente.getEnderecoCliente());
			stm.setString(4, cliente.getDtNascimentoCliente());
			stm.setInt(5, cliente.getTelefoneCliente());
			stm.setInt(6, cliente.getIdCliente());
			stm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idCliente) {
		String sqlDelete = "DELETE FROM Cliente WHERE idCliente=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1, idCliente);
			stm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Cliente carregar(int idCliente) {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(idCliente);
		String sqlSelect = "SELECT nomeCliente, cpfCliente, enderecoCliente, dtNascimentoCliente, telefoneCliente FROM Cliente WHERE Cliente.idCliente=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, cliente.getIdCliente());
			try (ResultSet rs = stm.executeQuery();){
				if(rs.next()) {
					cliente.setNomeCliente(rs.getString("nomeCliente"));
					cliente.setCpfCliente(rs.getInt("cpfCLiente"));
					cliente.setEnderecoCliente(rs.getString("enderecoCliente"));
					cliente.setDtNascimentoCliente(rs.getString("dtNascimentoCliente"));
					cliente.setTelefoneCliente(rs.getInt("telefoneCliente"));
				}else {
					cliente.setIdCliente(-1);
					cliente.setNomeCliente(null);
					cliente.setCpfCliente(-1);
					cliente.setEnderecoCliente(null);
					cliente.setDtNascimentoCliente(null);
					cliente.setTelefoneCliente(-1);
				}
				
				System.out.println(cliente.getNomeCliente());
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return cliente;
	}
	public ArrayList<Cliente> listarCliente(String chave){
		Cliente cliente;
		ArrayList<Cliente> lista = new ArrayList<>();
		String sqlSelect = "SELECT idCliente, nomeCliente, cpfCliente, enderecoCliente, dtNascimentoCliente, telefoneCliente FROM cliente WHERE upper(nomeCliente) like";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();){
				while(rs.next()) {
					cliente = new Cliente();
					cliente.setIdCliente(rs.getInt("idCliente"));
					cliente.setNomeCliente(rs.getString("nomeCliente"));
					cliente.setCpfCliente(rs.getInt("cpfCliente"));
					cliente.setEnderecoCliente(rs.getString("enderecoCliente"));
					cliente.setDtNascimentoCliente(rs.getString("dtNascimentoCliente"));
					cliente.setTelefoneCliente(rs.getInt("telefoneCliente"));
					lista.add(cliente);
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