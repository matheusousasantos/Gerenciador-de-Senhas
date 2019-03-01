package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Conta;
import bean.Usuario;
import dao.ContaDAO;
import dao.UsuarioDAO;

@WebServlet("/conta-servlet")
public class ContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ContaDAO dao = new ContaDAO();
	UsuarioDAO daoUsuario = new UsuarioDAO();

	public ContaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		try {
			
			Usuario usuarioSession = (Usuario) request.getSession().getAttribute("sessaoUsuario");		
			
			 if(acao.equalsIgnoreCase("contasPage")) {
					
				RequestDispatcher view = request.getRequestDispatcher("controle-senhas.jsp");
				request.setAttribute("usuarioNaSessao", usuarioSession);
				request.setAttribute("contas", dao.listar(usuarioSession.getId()));
				view.forward(request, response);
				
			}
			
			else if(acao.equalsIgnoreCase("editarConta")) {
			
				String id = request.getParameter("id");
				
				RequestDispatcher view = request.getRequestDispatcher("controle-senhas.jsp");
				request.setAttribute("conta", dao.consultar(id));
				request.setAttribute("usuarioNaSessao", usuarioSession);
				view.forward(request, response);
				
			}
			
			else if(acao.equalsIgnoreCase("excluirConta")) {
				
				String id = request.getParameter("id");
				
				dao.delete(id);
				
				RequestDispatcher view = request.getRequestDispatcher("controle-senhas.jsp");
				request.setAttribute("contas", dao.listar(usuarioSession.getId()));
				request.setAttribute("usuarioNaSessao", usuarioSession);
				view.forward(request, response);
				
			}
			 
			else if(acao.equalsIgnoreCase("pesquisarGrupoConta")) {
				
				String id = request.getParameter("id");
				
				System.out.println(id);
				System.out.println(acao);
				
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		Usuario usuarioSession = (Usuario) request.getSession().getAttribute("sessaoUsuario");
		ContaDAO contaDAO = new ContaDAO();
		
		System.out.println(acao);
		System.out.println(usuarioSession.getNome());
		
		try {
			
			if(acao != null && acao.equalsIgnoreCase("resetPage")) {
				
				RequestDispatcher view = request.getRequestDispatcher("controle-senhas.jsp");
				request.setAttribute("usuarioNaSessao", usuarioSession);
				request.setAttribute("contas", contaDAO.listar(usuarioSession.getId()));
				view.forward(request,response);
				
			} else {
				
				String id = request.getParameter("id");
				String descricao = request.getParameter("descricao");
				String link = request.getParameter("link");
				String login = request.getParameter("login");
				String senha = request.getParameter("senha");
				String tipo = request.getParameter("tipo");
				String imagem = request.getParameter("imagem");
				Long usuario = usuarioSession.getId();
				
				Conta conta = new Conta();
				conta.setId(!id.isEmpty() ? Long.parseLong(id) : null);
				conta.setDescricao(descricao);
				conta.setLink(link);
				conta.setLogin(login);
				conta.setSenha(senha);
				conta.setTipo(tipo);
				conta.setImagem(imagem);
				conta.setUsuario(usuario);
				
				if(id.isEmpty() || id == null) {
					contaDAO.salvar(conta);
				}
				
				else if(!id.isEmpty() && id != null) {
					contaDAO.atualizar(conta);
				}
				
				RequestDispatcher view = request.getRequestDispatcher("controle-senhas.jsp");
				request.setAttribute("usuarioNaSessao", usuarioSession);
				request.setAttribute("contas", contaDAO.listar(usuarioSession.getId()));
				view.forward(request,response);
		
			}
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		
	}
	
}
