package br.com.cs2.solos.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.cs2.solos.model.UsuarioModel;

@Stateless
public class UsuarioBusiness implements UsuarioBusinessLocal {

    public UsuarioBusiness() {
    }

	@Override
	public UsuarioModel cadastrar(UsuarioModel novoUsuario) {
		
		System.out.println("cadastrando o usuário: " + novoUsuario.getNome());
		
		return novoUsuario;
	}

	@Override
	public List<UsuarioModel> listar(String nomeDeUsuario) {
		
		System.out.println("buscando os usuários pelo nome: " + nomeDeUsuario);
		
		// Criar um usuario de exemplo
		UsuarioModel usuarioExemplo = new UsuarioModel();
		usuarioExemplo.setNome(nomeDeUsuario);
		
		// Criar uma lista de exemplo
		List<UsuarioModel> listaDeUsuarios = new ArrayList<>();
		
		// Adicionar o usuario de exemplo na lista para retorno simulando uma busca no banco de dados.
		listaDeUsuarios.add(usuarioExemplo);
		
		return listaDeUsuarios;
	}

	@Override
	public UsuarioModel atualizar(UsuarioModel usuarioExistente) {
		
		System.out.println("atualizando o usuario: " + usuarioExistente.getNome());
		
		return usuarioExistente;
	}

	@Override
	public void deletar(UsuarioModel usuarioParaDelecao) {
		System.out.println("deletando o usuário: " + usuarioParaDelecao.getNome());
	}

}
