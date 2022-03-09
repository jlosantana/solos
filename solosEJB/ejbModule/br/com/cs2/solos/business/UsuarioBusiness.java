package br.com.cs2.solos.business;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.cs2.solos.dao.UsuarioDao;
import br.com.cs2.solos.model.UsuarioModel;

@Stateless
public class UsuarioBusiness implements UsuarioBusinessFacade {

	// Simulação do banco de dados utilizando o LinkedList
	private List<UsuarioModel> usuarioDB = new LinkedList<>();

	public UsuarioBusiness() {
	}

	@Override
	public UsuarioModel cadastrar(UsuarioModel novoUsuario) {

		System.out.println("cadastrando o usuário: " + novoUsuario.getNome() + ", " + novoUsuario.getCpf());

		new UsuarioDao().inserir(novoUsuario);

		return novoUsuario;
	}

	@Override
	public List<UsuarioModel> listar(String nomeDeUsuario) {

		System.out.println("buscando os usuários pelo nome: " + nomeDeUsuario);

		return new UsuarioDao().listar();
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

		Iterator<UsuarioModel> it = usuarioDB.iterator();

		// enquanto for verdade
		while (it.hasNext()) {
			// faz um cast de Object para UsuarioModel
			UsuarioModel usuarioCorrente = (UsuarioModel) it.next();

			// compara com o usuario recebido para exclusão
			if (usuarioParaDelecao.equals(usuarioCorrente)) {
				// pede para o iterator fazer a remoção do objeto da lista
				it.remove();
				break;
			}
		}

	}

}
