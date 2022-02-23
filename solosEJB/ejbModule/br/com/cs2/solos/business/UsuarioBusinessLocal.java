package br.com.cs2.solos.business;

import java.util.List;

import javax.ejb.Local;

import br.com.cs2.solos.model.UsuarioModel;

@Local
public interface UsuarioBusinessLocal {

	UsuarioModel cadastrar(UsuarioModel novoUsuario);

	List<UsuarioModel> listar(String nomeDeUsuario);

	UsuarioModel atualizar(UsuarioModel usuarioExistente);

	void deletar(UsuarioModel usuarioParaDelecao);

}
