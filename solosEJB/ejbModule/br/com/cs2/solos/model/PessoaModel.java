package br.com.cs2.solos.model;

public class PessoaModel {

	private String nome;
	private String cpf;

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
	
	public void andar() {
		System.out.println("pessoa andando...");
	}

}
