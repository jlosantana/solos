package br.com.cs2.solos.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cs2.solos.business.UsuarioBusinessFacade;
import br.com.cs2.solos.model.UsuarioModel;

public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private InitialContext context;

	private UsuarioBusinessFacade usuarioBusiness;

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

			usuarioBusiness = (UsuarioBusinessFacade) context.lookup("solosEAR/UsuarioBusiness/local");

		} catch (Exception e) {
			// se ocorrer erro caia aqui nesse bloco
			System.out.println(e.getMessage());
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("executing get ...");

		// Parâmtetro recebido através da requisição GET
		// http://localhost:8080/solosWeb/usuario-servlet?nomeDeUsuario=Alexandre
		String nomeDeUsuarioRecebidoParaConsulta = request.getParameter("nomeDeUsuario");

		List<UsuarioModel> listaUsuarios = usuarioBusiness.listar(nomeDeUsuarioRecebidoParaConsulta);

		response.getWriter().append("<html><body>");

		for (UsuarioModel usuarioModel : listaUsuarios) {
			System.out.println("Nome do usuário: " + usuarioModel.getNome());
			response.getWriter().append("<h1>" + usuarioModel.getNome() + "</h1>");
		}
		
		response.getWriter().append("</body></html>");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("executing post ...");

		InputStream corpoDaMensagem = request.getInputStream();
		Reader leitorDeMensagemHTTP = new InputStreamReader(corpoDaMensagem); 
		BufferedReader leitorBufferizado = new BufferedReader(leitorDeMensagemHTTP);
		
		UsuarioModel novoUsuario;
		String nomeDoUsuario = "";
		String cpfDoUsuario = "";
		
		for (String linhaDaMensagem; (linhaDaMensagem = leitorBufferizado.readLine()) != null; ) {
			
			System.out.println("Linha da mensagem: " + linhaDaMensagem);
			
			nomeDoUsuario = linhaDaMensagem.split(",")[0].split("=")[1];
			cpfDoUsuario = linhaDaMensagem.split(",")[1].split("=")[1];
		}
		
		// Criando um usuário com o conteudo da mensagem
		novoUsuario = new UsuarioModel(nomeDoUsuario);
		novoUsuario.setCpf(cpfDoUsuario);
		
		// Cadastra o usuario com o nome enviado no corpo da requisição POST
		usuarioBusiness.cadastrar(novoUsuario);
		
		response.getWriter().append("<html><body>");
		response.getWriter().append("<h1>" + novoUsuario.getNome() + " cadastrado com sucesso!</h1>");
		response.getWriter().append("</body></html>");
		
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
