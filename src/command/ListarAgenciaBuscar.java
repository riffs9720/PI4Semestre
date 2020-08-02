package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Agencia;
import service.AgenciaService;

public class ListarAgenciaBuscar implements Command {
	
	@SuppressWarnings("null")
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		String idAgencia = request.getParameter("idAgencia");
		int idAgen = Integer.parseInt(idAgencia);
		Agencia modelAgencia = new Agencia();
		AgenciaService agencia = new AgenciaService();
		ArrayList<Agencia> lista = null;
		HttpSession session = request.getSession();
		HttpSession session2 = request.getSession();
		if (chave != null || chave.length() > 0) {
			lista = agencia.listarAgencia(chave);
		} else {
			lista = agencia.listarAgencia(null);
		}
		modelAgencia.setIdAgencia(idAgen);
		session.setAttribute("lista", lista);
		session2.setAttribute("idAgencia", modelAgencia);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("Conta.jsp");//verificar a questão de onde buscar
		dispatcher.forward(request, response);
	}
}