package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContaDAO;
import model.Agencia;
import model.Conta;

/**
 * Servlet implementation class autenticador
 */
@WebServlet("/autenticador")
public class autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession sessao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public autenticador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sessao = request.getSession(false);
		if(sessao==null){
			sessao.invalidate();
			
		}
		response.sendRedirect("login.jsp");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sconta = Integer.parseInt(request.getParameter("idConta"));
		int aconta = Integer.parseInt(request.getParameter("idAgencia"));
		int ssenha = Integer.parseInt(request.getParameter("senhaConta"));
		int stoken = Integer.parseInt(request.getParameter("token"));
		
		Conta cont = new Conta();
		Agencia agencia = new Agencia();
		cont.setNumeroConta(sconta);
		agencia.setIdAgencia(aconta);
		cont.setAgencia(agencia);
		cont.setSenhaConta(ssenha);
		cont.setnumeroToken(stoken);
	
		ContaDAO contDAO = new ContaDAO();
		Conta contAutenticado = contDAO.autenticacao(cont);
		
		System.out.println(contAutenticado);
		
		if(contAutenticado != null){
			HttpSession sessao = request.getSession();
			sessao.setAttribute("contAutenticado", contAutenticado);
			//sessao.setMaxInactiveInterval(3000);
			
				request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
