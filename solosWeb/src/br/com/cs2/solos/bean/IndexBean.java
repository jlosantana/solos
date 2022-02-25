package br.com.cs2.solos.bean;


public class IndexBean {

	private String mensagemDeBoasVindas;
	
	public IndexBean(){
		mensagemDeBoasVindas = "Seja bem vindo ao Solos Web";
	}

	public String getMensagemDeBoasVindas() {
		return mensagemDeBoasVindas;
	}

	public void setMensagemDeBoasVindas(String mensagemDeBoasVindas) {
		this.mensagemDeBoasVindas = mensagemDeBoasVindas;
	}

}
