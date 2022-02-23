package br.com.cs2.solos.model;

// Classe
public class UsuarioModel extends PessoaModel {

	// Atributos de classe
	private String login;
	private String senha;

	// Métodos
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
