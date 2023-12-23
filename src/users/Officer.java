/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package users;


/**
 * 
 * Interface da classe que representa uma variante de User ou seja Officer.
 *
 */


public interface Officer extends User {
	
	/**
	 * Verefica se o utlizador tem grant(acesso) para um dado documento.
	 * Pre: - userID != null && docName != null
	 * @param userID - identificador do utilizador.
	 * @param docName - nome do documento.
	 * @return - devolve true se foi dado um grant a este utilizador.
	 */
	boolean hasGrant(String userID, String docName);
	
	/**
	 * Devolve o numero de vezes que o utilizador recebeu um grant.
	 * @return - o numero de grants.
	 */
	int getNumberOfGrants();
	
	/**
	 * Devolve o numero de vezes que foi revocado uma grant ao utilizador.
	 * @return - o numero de vezes foi revocado.
	 */
	int getNumberOfRevokes();
		
	/**
	 * Da grant de um documento a outro utilizador com nivel de seguranca inferior.
	 * Pre: - docName != null && toBeGranteUser != null
	 * @param docName - nome do documento.
	 * @param toBeGrantedUser - identificador do utilizador a receber o grant.
	 */
	void giveGrant(String docName, User toBeGrantedUser);
	
	/**
	 * Revoca uma grant dado a outro utilizador anteriormente.
	 * Pre: - docName != null && toBeRevoked != null
	 * @param docName - nome do documento.
	 * @param toBeRevokedUser - nome do utilizador a perder grant.
	 */
	void revokeGrant(String docName, User toBeRevokedUser);	
	
}
