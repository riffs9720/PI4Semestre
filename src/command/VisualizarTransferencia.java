package command;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Transferencia;
import service.TransferenciaService;

public class VisualizarTransferencia implements Command{

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int idTransferencia = Integer.parseInt(request.getParameter("idTransferencia"));
		String identificacaoTransferencia = request.getParameter("identificacaoTransferencia");
		double valorTransferencia = Double.parseDouble(request.getParameter("valorTransferencia"));
		java.sql.Timestamp dtTransferencia = new Timestamp(System.currentTimeMillis());
		
	
		try {
			
		} catch (NumberFormatException e) {

		}

		Transferencia transferencia = new Transferencia();
		transferencia.setIdTransferencia(idTransferencia);
		transferencia.setIdentificacaoTransferencia(identificacaoTransferencia);
		transferencia.setValorTransferencia(valorTransferencia);
		transferencia.setDtTransferencia(dtTransferencia);
		
			
		TransferenciaService tf = new TransferenciaService();
		
		RequestDispatcher view = null;
		
		transferencia = tf.carregar(transferencia.getIdTransferencia());
		request.setAttribute("transferencia", transferencia);
		view = request.getRequestDispatcher("Transferencia.jsp");

		view.forward(request, response);

	}
}