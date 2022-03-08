package br.com.cs2.solos.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;

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

		try {

			Connection dbConecction = getConnection();

			String insertStatement = "INSERT INTO public.usuario(login, nome, cpf, senha) VALUES (?, ?, ?, ?)";

			PreparedStatement insertPreparedStatement = dbConecction.prepareStatement(insertStatement);

			insertPreparedStatement.setString(1, novoUsuario.getLogin());
			insertPreparedStatement.setString(2, novoUsuario.getNome());
			insertPreparedStatement.setString(3, novoUsuario.getCpf());
			insertPreparedStatement.setString(4, novoUsuario.getSenha());

			insertPreparedStatement.execute();

			insertPreparedStatement.close();
			dbConecction.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return novoUsuario;
	}

	@Override
	public List<UsuarioModel> listar(String nomeDeUsuario) {

		System.out.println("buscando os usuários pelo nome: " + nomeDeUsuario);

		try {

			Connection dbConecction = getConnection();

			String selectStatement = "select login, nome, cpf, senha from public.usuario";

			PreparedStatement selectPreparedStatement = dbConecction.prepareStatement(selectStatement);

			ResultSet resultado = selectPreparedStatement.executeQuery();

			List<UsuarioModel> retorno = null;
			UsuarioModel usuario = null;

			while (resultado.next()) {

				String login = resultado.getString(1);
				String nome = resultado.getString(2);
				String cpf = resultado.getString(3);
				String senha = resultado.getString(4);

				usuario = new UsuarioModel(nome);
				usuario.setLogin(login);
				usuario.setCpf(cpf);
				usuario.setSenha(senha);

				if (retorno == null) {
					retorno = new LinkedList<>();
				}

				retorno.add(usuario);
			}

			resultado.close();
			dbConecction.close();

			return retorno;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
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

	public Connection getConnection() throws SQLException {

		String url = "jdbc:postgresql://localhost:5432/solos?user=postgres&password=postgres";

		Connection conn = DriverManager.getConnection(url);

		return conn;
	}

}
