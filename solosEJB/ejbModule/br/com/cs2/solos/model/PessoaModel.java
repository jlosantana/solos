package br.com.cs2.solos.model;

import java.io.Serializable;

public class PessoaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpf;
	
	public PessoaModel(String novoNome) {
		this.nome = novoNome;
	}

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
