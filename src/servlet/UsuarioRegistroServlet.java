package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Usuario;
import dao.UsuarioDAO;


@WebServlet("/usuario-registro-servlet")
public class UsuarioRegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UsuarioDAO dao = new UsuarioDAO();
   
    public UsuarioRegistroServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doGet");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String nome = request.getParameter("cad-nome");
		String login = request.getParameter("cad-login");
		String senha = request.getParameter("cad-senha");
		String email = request.getParameter("cad-email");
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setEmail(email);
		
		dao.salvar(usuario);
		
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		request.setAttribute("msg", "Usuario salvo com sucesso!");
		view.forward(request, response);
		
	}
		

}
