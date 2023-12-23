/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package users;


/**
 * Classe que representa uma variante de User contendo os metodos e variaveis 
 * associados as acoes que um utilizador do tipo Clerk possa ter na aplicacao.
 */


public class ClerkClass extends UserClass {

	/**
	 * Construtor da clase que envoca o construtor da superclasse.
	 * Pre: - userType != null && id != null && clearence != null 
	 * @param userType - Tipo de utilizador.
	 * @param id - Identificador do utilizador.
	 * @param clearenceLevel - Nivel de seguranca do utilizador.
	 */
	public ClerkClass(String userType, String id, String clearenceLevel) {
		super(userType, id, clearenceLevel);
	}

}
