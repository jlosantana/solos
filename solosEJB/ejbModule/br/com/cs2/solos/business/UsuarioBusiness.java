package br.com.cs2.solos.business;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.cs2.solos.model.UsuarioModel;

@Stateless
public class UsuarioBusiness implements UsuarioBusinessLocal {
	
	// Simulação do banco de dados utilizando o LinkedList
	private List<UsuarioModel> usuarioDB = new LinkedList<>();

    public UsuarioBusiness() {
    }

	@Override
	public UsuarioModel cadastrar(UsuarioModel novoUsuario) {
		
		System.out.println("cadastrando o usuário: " + novoUsuario.getNome());
		
		usuarioDB.add(novoUsuario);
		
		return novoUsuario;
	}

	@Override
	public List<UsuarioModel> listar(String nomeDeUsuario) {
		
		System.out.println("buscando os usuários pelo nome: " + nomeDeUsuario);
		
		return usuarioDB;
	}

	@Override
	public UsuarioModel atualizar(UsuarioModel usuarioParaAtualizacao) {
		
		System.out.println("atualizando o usuario: " + usuarioParaAtualizacao.getNome());
		
		for (UsuarioModel usuarioCorrente : usuarioDB) {
			if (usuarioParaAtualizacao.equals(usuarioCorrente)) {
				// atualizando CPF
				usuarioCorrente.setCpf(usuarioParaAtualizacao.getCpf());
				// atualizando o login
				usuarioCorrente.setLogin(usuarioParaAtualizacao.getLogin());
				// atualizando o nome
				usuarioCorrente.setNome(usuarioParaAtualizacao.getNome());
				// atualizando a senha
				usuarioCorrente.setSenha(usuarioParaAtualizacao.getSenha());
			}
		}
		
		return usuarioParaAtualizacao;
	}

	@Override
	public void deletar(UsuarioModel usuarioParaDelecao) {
		
		System.out.println("deletando o usuário: " + usuarioParaDelecao.getNome());
		
		for (UsuarioModel usuarioCorrente : usuarioDB) {
			if (usuarioParaDelecao.equals(usuarioCorrente)) {
				usuarioDB.remove(usuarioCorrente);
			}
		}
	}

}
