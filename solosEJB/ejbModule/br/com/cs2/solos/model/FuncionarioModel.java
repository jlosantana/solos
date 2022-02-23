package br.com.cs2.solos.model;

public class FuncionarioModel extends PessoaModel {

	private String numeroMatricula;

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	@Override
	public void andar() {
		System.out.println("funcionario andando...");
	}
	
	public void correr() {
		System.out.println("funcionario correndo...");
	}
}
