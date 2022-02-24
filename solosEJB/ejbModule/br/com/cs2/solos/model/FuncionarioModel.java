package br.com.cs2.solos.model;

public class FuncionarioModel extends PessoaModel {

	private static final long serialVersionUID = 1L;

	private String numeroMatricula;

	public FuncionarioModel(String nomeFuncionario) {
		super(nomeFuncionario);
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

}
