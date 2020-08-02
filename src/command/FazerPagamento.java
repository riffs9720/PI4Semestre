package command;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import model.Pagamento;
import model.Agencia;
import model.Conta;
import service.PagamentoService;

public class FazerPagamento implements Command{

	@SuppressWarnings("unused")
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Conta contAutenticado = (Conta) request.getSession().getAttribute("contAutenticado");
		String pValorPagamento = request.getParameter("valorPagamento");
		String pSaldoConta = request.getParameter("saldoConta");
		String pIdentificacaoPagamento = request.getParameter("identificacaoPagamento");
		
		//SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Timestamp dtPagamento = new Timestamp(System.currentTimeMillis());
		
		double valorPagamento = 0.0;
		int idPagamento = 0;
		Date dtVencimento = null;
		
		
		try {
			valorPagamento = Double.parseDouble(pValorPagamento);
		}catch(NumberFormatException e){
		}
		
		Agencia agencia = new Agencia();
		Pagamento pagamento = new Pagamento();
		PagamentoService service = new PagamentoService();
		Conta conta = new Conta();
		
		conta.setAgencia(contAutenticado.getAgencia());
		conta.setNumeroConta(contAutenticado.getNumeroConta());
		conta.setSenhaConta(contAutenticado.getSenhaConta());
		conta.setSaldoConta(contAutenticado.getSaldoConta());
		pagamento.setConta(conta);
		pagamento.setIdPagamento(idPagamento);
		pagamento.setIdentificaPagamento(pIdentificacaoPagamento);
		pagamento.setValorPagamento(valorPagamento);
		pagamento.setDtPagamento(dtPagamento);
	
		service.fazPagamento(conta, pagamento, agencia);
		
		System.out.println(pIdentificacaoPagamento);
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Pagamento> lista = new ArrayList<>();
		lista.add(pagamento);
		
		session.setAttribute("lista", lista);
		request.setAttribute("pagamento", pagamento);
		view = request.getRequestDispatcher("Pagamento.jsp");

		view.forward(request, response);		
	}
}