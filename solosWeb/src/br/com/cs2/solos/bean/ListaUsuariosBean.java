package br.com.cs2.solos.bean;

import java.util.List;

import javax.naming.InitialContext;

import br.com.cs2.solos.business.UsuarioBusinessLocal;
import br.com.cs2.solos.model.UsuarioModel;

public class ListaUsuariosBean {

	// Atributos da classe
	private InitialContext context;

	private UsuarioBusinessLocal usuarioBusiness;

	private List<UsuarioModel> listaUsuarios;

	// Construtores
	public ListaUsuariosBean() {

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
	public List<UsuarioModel> getListaUsuarios() {
		
		listaUsuarios = usuarioBusiness.listar("João");
		
		return listaUsuarios;
	}

	public void setListaUsuarios(List<UsuarioModel> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
