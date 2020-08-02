package command;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Conta;
import model.Transacao;
import service.TransacaoService;

public class ListarTransacao implements Command{
	
		@Override
		public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			TransacaoService transacao = new TransacaoService();
			Conta conta = new Conta();
			ArrayList<Transacao> lista = new ArrayList<Transacao>();
			HttpSession session = request.getSession();
			
			
			Conta contAutenticado = (Conta) request.getSession().getAttribute("contAutenticado");
			
			conta.setNumeroConta(contAutenticado.getNumeroConta());
			
			lista = transacao.listarTransacao();
			session.setAttribute("lista", lista);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("Conta.jsp");
			dispatcher.forward(request, response);
		}

}
