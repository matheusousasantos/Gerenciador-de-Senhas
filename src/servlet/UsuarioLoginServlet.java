package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Usuario;
import dao.ContaDAO;
import dao.UsuarioDAO;


@WebServlet("/usuario-login-servlet")
public class UsuarioLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UsuarioDAO dao = new UsuarioDAO();
	ContaDAO daoContas = new ContaDAO();
   
    public UsuarioLoginServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doGet");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
		
		String login = request.getParameter("log-login");
		String senha = request.getParameter("log-senha");
		
		Usuario usuario = dao.logar(login, senha);
			
		if(usuario == null) {
			
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Usuário não existe no banco de dados");
			view.forward(request, response);
			
		} else if(usuario != null){
			
		request.getSession().setAttribute("sessaoUsuario", usuario);
		
		RequestDispatcher view = request.getRequestDispatcher("controle-acao.jsp");
		request.setAttribute("usuarioNaSessao", usuario);
		request.setAttribute("contas", daoContas.listar(usuario.getId()));
		view.forward(request, response);
		
		}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
		

}
