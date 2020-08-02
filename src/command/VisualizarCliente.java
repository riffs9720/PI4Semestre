package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;

public class VisualizarCliente implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int pIdCliente = Integer.parseInt(request.getParameter("idCliente"));
		int pCpfCliente = Integer.parseInt(request.getParameter("cpfCliente"));
		int pTelefoneCliente = Integer.parseInt(request.getParameter("telefoneCliente"));
		String pNomeCliente = request.getParameter("nomeCliente");
		String pEnderecoCliente = request.getParameter("enderecoCliente");
		String pDtNascimentoCliente = request.getParameter("dtNascimentoCliente");
	
		pIdCliente = -1;
		pCpfCliente = -1;
		pTelefoneCliente = -1;
		
		try {
			pIdCliente = -1;
			pCpfCliente = -1;
		} catch (NumberFormatException e) {

		}

		Cliente cliente = new Cliente();
		cliente.setIdCliente(pIdCliente);
		cliente.setCpfCliente(pCpfCliente);
		cliente.setTelefoneCliente(pTelefoneCliente);
		cliente.setNomeCliente(pNomeCliente);
		cliente.setEnderecoCliente(pEnderecoCliente);
		cliente.setDtNascimentoCliente(pDtNascimentoCliente);
			
		ClienteService cs = new ClienteService();
		
		RequestDispatcher view = null;
		cliente = cs.carregar(cliente.getIdCliente());
		request.setAttribute("cliente", cliente);
		view = request.getRequestDispatcher("Conta.jsp");

		view.forward(request, response);

	}
}