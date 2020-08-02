package command;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagamento;
import service.PagamentoService;

public class VisualizarPagamento implements Command {
	
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int idPagamento = Integer.parseInt(request.getParameter("idPagamento"));
		String identificaPagamento = request.getParameter("identificaPagamento");
		double valorPagamento = Double.parseDouble(request.getParameter("valorPagamento"));
		java.sql.Timestamp dtPagamento = new Timestamp(System.currentTimeMillis());
		
	
		try {
			
		} catch (NumberFormatException e) {

		}

		Pagamento pagamento = new Pagamento();
		pagamento.setIdPagamento(idPagamento);
		pagamento.setIdentificaPagamento(identificaPagamento);
		pagamento.setValorPagamento(valorPagamento);
		pagamento.setDtPagamento(dtPagamento);
		
			
		PagamentoService pg = new PagamentoService();
		
		RequestDispatcher view = null;
		
		pagamento = pg.carregar(pagamento.getIdPagamento());
		request.setAttribute("pagamento", pagamento);
		view = request.getRequestDispatcher("pagamento.jsp");

		view.forward(request, response);

	}
}