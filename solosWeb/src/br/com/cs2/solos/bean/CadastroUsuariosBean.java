package br.com.cs2.solos.bean;

import javax.naming.InitialContext;

import br.com.cs2.solos.business.UsuarioBusinessLocal;
import br.com.cs2.solos.model.UsuarioModel;

// Controller layer
public class CadastroUsuariosBean {

	// atributos de classe
	private String nome;

	private InitialContext context;

	private UsuarioBusinessLocal usuarioBusiness;

	// construtor

	// métodos

	public String salvarUsuario() {
		// TODO fazer o lookup do EJB e invocar o salvar passando o usuriomodel
		// preenchido com os valores que foram informados no formulário

		// Meu código
		try {
			// executa a criação do contexto
			context = new InitialContext();

			usuarioBusiness = (UsuarioBusinessLocal) context.lookup("solosEAR/UsuarioBusiness/local");
			
			UsuarioModel novoUsuario = new UsuarioModel(this.nome);
			
			usuarioBusiness.cadastrar(novoUsuario);

		} catch (Exception e) {
			// se ocorrer erro caia aqui nesse bloco
			System.out.println(e.getMessage());
		}

		return "success";
	}

	// getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
