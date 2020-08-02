package service;

import java.util.ArrayList;

import model.Agencia;
//import model.Usuario;
import dao.AgenciaDAO;
//import dao.UsuarioDAO;

//Está classe chama o ClienteDAO, ele executa os metodos da classe DAO.

public class AgenciaService {
	AgenciaDAO dao = new AgenciaDAO();
	
	public int criar(Agencia agencia) {
		return dao.criar(agencia);
	}
	
	public void atualizar(Agencia agencia) {
		dao.atualizar(agencia);
	}
	
	public void excluir (int idAgencia) {
		dao.excluir(idAgencia);
	}
	
	public Agencia carregar(int idAgencia) {
		return dao.carregar(idAgencia);
	}
	public ArrayList<Agencia> listarAgencia(String chave) {
		return dao.listarAgencia(chave);
	}
	public boolean validar(Agencia agencia){
		AgenciaDAO dao = new AgenciaDAO();
		return dao.validar(agencia);
	}
}