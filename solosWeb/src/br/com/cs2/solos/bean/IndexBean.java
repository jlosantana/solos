package br.com.cs2.solos.bean;

import java.util.List;

import javax.naming.InitialContext;

import br.com.cs2.solos.business.UsuarioBusinessLocal;
import br.com.cs2.solos.model.UsuarioModel;


public class IndexBean {

	// Propriedades / atributos de classe
	private String mensagemDeBoasVindas;
	
	private InitialContext context;

	private UsuarioBusinessLocal usuarioBusiness;
	
	private List<UsuarioModel> listaUsuarios;
	
	// Construtores
	public IndexBean(){
		mensagemDeBoasVindas = "Seja bem vindo ao Solos Web";
		
		// Meu código
		try {
			// executa a criação do contexto
			context = new InitialContext();

			usuarioBusiness = (UsuarioBusinessLocal) context.lookup("solosEAR/UsuarioBusiness/local");

		} catch (Exception e) {
			// se ocorrer erro caia aqui nesse bloco
			System.out.println(e.getMessage());
		}
	}
	
	// Getters e setters

	public String getMensagemDeBoasVindas() {
		return mensagemDeBoasVindas;
	}

	public void setMensagemDeBoasVindas(String mensagemDeBoasVindas) {
		this.mensagemDeBoasVindas = mensagemDeBoasVindas;
	}
	
	public List<UsuarioModel> getListaUsuarios() {
		
		listaUsuarios = usuarioBusiness.listar("João");
		
		return listaUsuarios;
	}

	public void setListaUsuarios(List<UsuarioModel> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}


}
