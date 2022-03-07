package br.com.cs2.solos.factory;

import javax.naming.InitialContext;

import br.com.cs2.solos.business.UsuarioBusinessFacade;

// Factory
public class FacadeFactory {
	
	private static FacadeFactory instance;
	
	// Singleton
	public static FacadeFactory getInstace() {
		
		// Primeira vez que o getInstance é chamado
		if (instance == null) {
			instance = new FacadeFactory();
		}
		
		return instance;
	}

	// Factory method
	public UsuarioBusinessFacade criarBusinessFacade() {
		// Meu código de criação do EJB (lookup)
		try {
			// executa a criação do contexto
			InitialContext context = new InitialContext();

			UsuarioBusinessFacade usuarioBusiness = (UsuarioBusinessFacade) context.lookup("solosEAR/UsuarioBusiness/local");

			return usuarioBusiness;

		} catch (Exception e) {
			// se ocorrer erro caia aqui nesse bloco
			System.out.println(e.getMessage());
		}

		return null;
	}

}
