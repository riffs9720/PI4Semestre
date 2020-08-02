package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Conta;
import service.ContaService;

public class ListarContaBuscar implements Command{

	@SuppressWarnings("null")
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		ContaService conta = new ContaService();
		ArrayList<Conta> lista = null;
		HttpSession session = request.getSession();
		if (chave != null || chave.length() > 0) {
			lista = conta.listarConta(chave);
		} else {
			lista = conta.listarConta(null);
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("Conta.jsp");
		dispatcher.forward(request, response);
	}
}