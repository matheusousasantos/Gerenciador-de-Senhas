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

@WebServlet("/usuario-servlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioDAO dao  = new UsuarioDAO();
       
    public UsuarioServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		try {
			
			Usuario usuarioSession = (Usuario) request.getSession().getAttribute("sessaoUsuario");
		
			if(acao.equalsIgnoreCase("editarPage")) {
				
				RequestDispatcher view = request.getRequestDispatcher("editar-usuario.jsp");
				request.setAttribute("usuarioNaSessao", usuarioSession);
				view.forward(request, response);
			}
			
			else if(acao.equalsIgnoreCase("homePage")) {
				
				RequestDispatcher view = request.getRequestDispatcher("controle-acao.jsp");
				request.setAttribute("usuarioNaSessao", usuarioSession);
				view.forward(request, response);
			}
			
			else if(acao.equalsIgnoreCase("contasPage")) {
				
				RequestDispatcher view = request.getRequestDispatcher("controle-senhas.jsp");
				request.setAttribute("usuarioNaSessao", usuarioSession);
				view.forward(request, response);
			}
			
			else if(acao.equalsIgnoreCase("infoPage")) {
				
				RequestDispatcher view = request.getRequestDispatcher("info.jsp");
				request.setAttribute("usuarioNaSessao", usuarioSession);
				view.forward(request, response);
			}
			
			else if(acao.equalsIgnoreCase("deletePage")) {
				
				dao.delete(usuarioSession.getId().toString());
				request.getSession().invalidate();
				
				RequestDispatcher view = request.getRequestDispatcher("controle-acao.jsp");
				view.forward(request, response);
			}
			
			else if(acao.equalsIgnoreCase("sairPage")) {
				
				RequestDispatcher view = request.getRequestDispatcher("index.jsp");
				view.forward(request, response);
			}
		
		} catch(Exception ex) {
			ex.getStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
		
		String id = request.getParameter("cad-id");
		String nome = request.getParameter("cad-nome");
		String login = request.getParameter("cad-login");
		String senha = request.getParameter("cad-senha");
		String email = request.getParameter("cad-email");
		
		Usuario usuario = new Usuario();
		usuario	= dao.consultar(id);
		
		usuario.setId(Long.parseLong(id));
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setEmail(email);
		
		dao.atualizar(usuario);
		
		request.getSession().setAttribute("sessaoUsuario", usuario);
		
		Usuario usuarioSession = (Usuario) request.getSession().getAttribute("sessaoUsuario");
		
		System.out.println(usuarioSession.getId());
		System.out.println(usuarioSession.getNome());
		System.out.println(usuarioSession.getLogin());
		System.out.println(usuarioSession.getSenha());
		System.out.println(usuarioSession.getEmail());
		
		RequestDispatcher view = request.getRequestDispatcher("editar-usuario.jsp");
		request.setAttribute("usuarioNaSessao", usuarioSession);
		view.forward(request, response);

		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
