package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pagamento;
import service.PagamentoService;

public class ListarPagamentoBuscar implements Command{

	@SuppressWarnings("null")
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		PagamentoService pagamento = new PagamentoService();
		ArrayList<Pagamento> lista = null;
		HttpSession session = request.getSession();
		if (chave != null || chave.length() > 0) {
			lista = pagamento.listarPagamento(chave);
		} else {
			lista = pagamento.listarPagamento(null);
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("Pagamento.jsp");
		dispatcher.forward(request, response);
	}
}