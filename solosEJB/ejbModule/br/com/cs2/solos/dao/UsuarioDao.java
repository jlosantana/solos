package br.com.cs2.solos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.com.cs2.solos.model.UsuarioModel;

public class UsuarioDao {

	public UsuarioModel inserir(UsuarioModel novoUsuario) {
		
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
	
	public List<UsuarioModel> listar() {
		
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
	
	public Connection getConnection() throws SQLException {

		String url = "jdbc:postgresql://localhost:5432/solos?user=postgres&password=postgres";

		Connection conn = DriverManager.getConnection(url);

		return conn;
	}
}
