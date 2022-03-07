package br.com.cs2.solos.bean;

import br.com.cs2.solos.business.UsuarioBusinessFacade;
import br.com.cs2.solos.factory.FacadeFactory;
import br.com.cs2.solos.model.UsuarioModel;

// Controller layer
public class CadastroUsuariosBean {

	// atributos de classe
	private String nome;

	private String cpf;

	private String login;

	private String senha;

	private UsuarioBusinessFacade usuarioBusiness;

	// construtor

	// métodos

	public String salvarUsuario() {

		usuarioBusiness = FacadeFactory.getInstace().criarBusinessFacade();

		UsuarioModel novoUsuario = new UsuarioModel(this.nome);
		novoUsuario.setCpf(this.cpf);
		novoUsuario.setLogin(this.login);
		novoUsuario.setSenha(this.senha);

		usuarioBusiness.cadastrar(novoUsuario);

		return "success";
	}

	// getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
