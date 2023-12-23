/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package documents;


/**
 * 
 * Interface da classe que representa uma variante de Document ou seja o classified document.
 *
 */


import dataStructures.Iterator;
import users.User;


public interface ClassifiedDoc extends Document {
	
	/**
	 * Verifica se um utilizador de nivel de seguranca inferior ao documento
	 * tem grant(acesso) ao documento.
	 * Pre: - userID != null
	 * @param userID - identificador do utilizador.
	 * @return - devolve true se o utilizador tiver grant.
	 */
	boolean hasGrant(String userID);
	
	/**
	 * Verfica se a grant dada a um utilizador de nivel de seguranca inferior ao documento
	 * ja foi revocada.
	 * Pre: - userID != null
	 * @param userID - identificador do utilizador.
	 * @return - devolve true se a grant ja foi revocada.
	 */
	boolean hasRevoke(String userID);
	
	/**
	 * Devolve um iterador que itera sobre o historico
	 * de acessos dados e revocados no documento relacionados 
	 * com os utilizadores.
	 * @return - um objeto do tipo Iterator com o historico de acessos.
	 */
	Iterator<String> getInfoGrantsIterator();
	
	/**
	 * Devolve um iterador que itera sobre o historico
	 * de utilizadores que receberam  acesso(grant) ao documento.
	 * @return - Devolve um objeto do tipo Iterator com o historico de utilizadores.
	 */
	Iterator<User> getUserGrantsIterator();
	
	/**
	 * Devolve o numero de vezes que o documento foi cedido para utilizadores de nivel de 
	 * seguranca inferior ao documento.
	 * @return - numero de vezes que o documento foi cedido.
	 */
	int getNumberOfLeaks();
	
	/**
	 * Devolve o numero de vezes que o acesso cedido foi revocado para utilizadores de 
	 * nivel de seguranca inferior ao documento.
	 * @return - numero de vezes que o acesso cedido foi revocado.
	 */
	int getNumberOfRevokeds();
	
	/**
	 * Devolve o numero de vezes que o documento foi reescrito.
	 * @return - numero de vezes que o documento foi reescrito.
	 */
	int getNumberOfUpdates();
	
	/**
	 * Adiciona um utilizador que recebeu grant a colecao de utilizadores com grants
	 * e ao historico de acessos cedidos e revocados a utilizadores ao documento do documento.
	 * Pre: - usr != null
	 * @param usr - utilizador que recebeu grant
	 */
	void addGrantedUser(User usr);
	
	/**
	 * Adiciona um utilizador que cuja grant foi revocada a colecao de utilizadores 
	 * com revokes e ao historico de acessos cedidos e revocados utilizadores
	 *  ao documento do documento.
	 * Pre: - usr != null
	 * @param usr - utilizador que cuja grant foi revocada.
	 */
	void addRevokedUser(User usr);
	
	/**
	 * Modifica a descricao do documento de acordo com os dados fornecidos e adiciona
	 * o utilizador que modifica a descricao ao historico de tipos de acessos ao 
	 * documento do documento.
	 * Pre: - writer != null && description != null
	 * @param writer - utilizador que modifica descricao do documento. 
	 * @param description - nova descricao do documento.
	 */
	void update(User writer, String description);
	
}
