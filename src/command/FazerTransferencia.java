package command;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Agencia;
import model.Conta;
import model.Transferencia;
import service.ContaService;
import service.TransferenciaService;

public class FazerTransferencia implements Command {

	@SuppressWarnings("unused")
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Conta contAutenticado = (Conta) request.getSession().getAttribute("contAutenticado");
		String pNumeroContaDestino = request.getParameter("digitoContaDestino");
		String pCpfBeneficiadoTransferencia = request.getParameter("cpfBeneficiadoTransferencia");
		String pValorTransferencia = request.getParameter("valorTransferencia");
		String IdentificacaoTransferencia = request.getParameter("identificacaoTransferencia");
		Timestamp dtTransferencia = new Timestamp(System.currentTimeMillis());
		
		int numeroContaDestino = 0;
		int cpfBeneficiadoTransferencia = 0;
		double valorTransferencia = 0;
		
		try {
			numeroContaDestino = Integer.parseInt(pNumeroContaDestino);	
			valorTransferencia = Double.parseDouble(pValorTransferencia);
			cpfBeneficiadoTransferencia = Integer.parseInt(pCpfBeneficiadoTransferencia);
		}catch(NumberFormatException e) {
		System.out.println(e.getMessage());
		}
		
		Transferencia transferencia = new Transferencia();
		Conta contaOrigem = new Conta();
		Conta contaDestino = new Conta();
		Agencia agencia = new Agencia();
		TransferenciaService transferenciaService = new TransferenciaService();
		ContaService contaService = new ContaService();
	
		contaOrigem.setNumeroConta(contAutenticado.getNumeroConta());
		agencia.setIdAgencia(contAutenticado.getAgencia().getIdAgencia());
		
		transferencia.setValorTransferencia(valorTransferencia);
		transferencia.setCpfBeneficiadoTransferencia(cpfBeneficiadoTransferencia);
		transferencia.setIdentificacaoTransferencia(IdentificacaoTransferencia);
		transferencia.setDtTransferencia(dtTransferencia);
		transferenciaService.fazTransferencia(contaOrigem, contaDestino, transferencia);
				
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList<Transferencia> lista = new ArrayList<>();
		lista.add(transferencia);
		
		session.setAttribute("lista", lista);
		session.setAttribute("transferencia", transferencia);
		view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);	
	}
}