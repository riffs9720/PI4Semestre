package command;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conta;
import service.ContaService;

public class VisualizarConta implements Command{

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int idConta = Integer.parseInt(request.getParameter("idConta"));
		int senhaConta = Integer.parseInt(request.getParameter("senhaConta"));
		double saldoConta = Double.parseDouble(request.getParameter("saldoConta"));
		java.sql.Timestamp dtAbertura = new Timestamp(System.currentTimeMillis());
		
	
		try {
			
		} catch (NumberFormatException e) {

		}

		Conta conta = new Conta();
		conta.setNumeroConta(idConta);
		conta.setSenhaConta(senhaConta);
		conta.setDtAbertura(dtAbertura);
		conta.setSaldoConta(saldoConta);
		
		
		//atualizado até aqui
		ContaService cs = new ContaService();
		
		RequestDispatcher view = null;

		conta = cs.carregar(conta.getNumeroConta());
		request.setAttribute("conta", conta);
		view = request.getRequestDispatcher("Conta.jsp");

		view.forward(request, response);

	}
}