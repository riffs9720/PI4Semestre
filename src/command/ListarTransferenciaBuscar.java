package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Transferencia;
import service.TransferenciaService;

public class ListarTransferenciaBuscar implements Command{
	
	@SuppressWarnings("null")
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		TransferenciaService transferencia = new TransferenciaService();
		ArrayList<Transferencia> lista = null;
		HttpSession session = request.getSession();
		if (chave != null || chave.length() > 0) {
			lista = transferencia.listarTransferencia(chave);
		} else {
			lista = transferencia.listarTransferencia(null);
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("Transferencia.jsp");
		dispatcher.forward(request, response);
	}
}