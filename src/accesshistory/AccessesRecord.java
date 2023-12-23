/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package accesshistory;


/**
 * Interface da classe que representa o historico de acessos 
 * e grants de um documento. 
 */


import dataStructures.Iterator;
import users.User;


public interface AccessesRecord {
	
	/**
	 * Verifica se um utilizador com identificador igual a userID existe
	 * na colecao.
	 * Pre: - userID != null
	 * @param userID - identificador do utilizador.
	 * @return - devovle true se o utilizador existe na colecao.
	 */
	boolean hasUser(String userID);
	
	/**
	 * Devovolve o numero de utilizadores na colecao.
	 * @return - numero de utilizadores.
	 */
	int getNumberOfUsers(); 
	
	/**
	 * Devolve um iterador de objetos do tipo Strings que itera sobre 
	 * historico de informacao.
	 * @return - objeto do tipo Iterator de Strings.
	 */
	Iterator<String> getInfoIterator();
	
	/**
	 * Devolve um iterador de objetos do tipo User
	 * que itera sobre a colecao desses objetos.
	 * @return - objeto do tipo Iterator de objetos do tipo User.
	 */
	Iterator<User> getUserIterator();
	
	/**
	 * Adiciona um utilizador a colecao de objetos do tipo User
	 * e a informacao relacionada com a acao do utilizador ou de outro perante
	 * (read, write, grant, revoke) um documento.
	 * Pre: - usr != null && info != null
	 * @param usr - utilizador que vai ser adicionado a colecao.
	 * @param info - informacao da acao do utilizador no documento.
	 */
	void addToHistory(User usr, String info);
		
	/**
	 * Devolve a informacao relacionada com o utilizador que tem o identificador
	 * igual a userID.
	 * Pre: - userID != null && hasUser(userID)
	 * @param userID - indentificador do utilizador.
	 * @return - a informacao relacionada com o utilizador.
	 */
	String getUserInfo(String userID);
	
	/**
	 * Devolve o objeto do tipo User que tem o identificador igual 
	 * userID.
	 * Pre: - userID != null && hasUser(userID)
	 * @param userID - identificador do utilizador.
	 * @return - objeto do tipo User.
	 */
	User getUser(String userID);
	
}
