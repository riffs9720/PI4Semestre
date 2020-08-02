package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Esta classe abre e fecha a conexão com o banco.

public class ConnectionFactory {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Obtem conexão com o banco de dados
	public static Connection obtemConexao() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost/CuelharBank?user=root&password=009720");
	}
}
