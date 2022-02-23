package br.com.cs2.solos.model;

// Classe
public class UsuarioModel extends PessoaModel {

	private static final long serialVersionUID = 1L;

	// Atributos de classe
	private String login;
	private String senha;
	
	public UsuarioModel(String nomeUsuario) {
		super(nomeUsuario);
	}

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
