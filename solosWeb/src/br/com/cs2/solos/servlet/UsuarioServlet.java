package br.com.cs2.solos.servlet;

import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cs2.solos.business.UsuarioBusinessLocal;
import br.com.cs2.solos.model.UsuarioModel;

public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private InitialContext context;
	
	private UsuarioBusinessLocal usuarioBusiness;

	// Construtor
	public UsuarioServlet() {
		super();
	}
	
	@Override
	public void init() throws ServletException {
		
		// Executo o código da classe mão para evitar problemas
		super.init();

		// Meu código
		try {
			// executa a criação do contexto
			context = new InitialContext();
			
			usuarioBusiness = (UsuarioBusinessLocal) context.lookup("solosEAR/UsuarioBusiness/local");
			
		} catch (Exception e) {
			// se ocorrer erro caia aqui nesse bloco
			System.out.println(e.getMessage());
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("executing get ...");
		
		String nomeDeUsuario = request.getParameter("nomeDeUsuario");
		
		List<UsuarioModel> listaUsuarios = usuarioBusiness.listar(nomeDeUsuario);
		
		for (UsuarioModel usuarioModel : listaUsuarios) {
			System.out.println("Nome do usuário: " + usuarioModel.getNome());
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("executing post ...");
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("executing put ...");
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("executing delete ...");
	}

}
