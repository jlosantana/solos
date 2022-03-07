package br.com.cs2.solos.bean;

import java.util.List;

import br.com.cs2.solos.business.UsuarioBusinessFacade;
import br.com.cs2.solos.factory.FacadeFactory;
import br.com.cs2.solos.model.UsuarioModel;

public class ListaUsuariosBean {

	// Atributos da classe
	private UsuarioBusinessFacade usuarioBusiness;

	private List<UsuarioModel> listaUsuarios;

	// Construtores
	public ListaUsuariosBean() {

		usuarioBusiness = FacadeFactory.getInstace().criarBusinessFacade();

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
