/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package collections;


/**
 * Interface da classe que representa uma colecao de objetos do tipo User. 
 */


import dataStructures.Iterator;
import users.User;


public interface UserCollection {

	/**
	 * Verifica se um elemento com o nome/identificador igual
	 * a name existe na colecao.
	 * Pre: - name != null
	 * @param name - nome/identificador do elemento.
	 * @return - devolve true se o elemento existir na colecao.
	 */
	boolean hasUser(String userID);

	/**
	 * Devolve o elemento que tem o nome/identificador igual
	 * a name.
	 * Pre: - name != null && hasElement(name)
	 * @param name - nome/identificador do elemento.
	 * @return - elemento com o nome/identificador igual a name.
	 */
	User getUser(String userID);

	/**
	 * Devolve um iterador dos elemntos da colecao.
	 * @return - iterador de elementos da colecao.
	 */
	Iterator<User> getIterator();

	/**
	 * Ordena a colecao de utilizadores do tipo Officer
	 * por ordem decrescente do numero de acessos cedidos 
	 * (grants) a outros utilizadores  atraves da criacao de um novo
	 * objeto do tipo UserCollection onde vao ser inseridos ordenadamente
	 * os utilizadores, retornando o iterador dessa colecao temporaria de
	 * utilizadores.
	 * Utiliza o metodo insertion sort. 
	 */
	Iterator<User> getSortedIterator();

	/**
	 * Adiciona o elemento na proxima posicao livre da colecao.
	 * Pre: elm != null
	 * @param elm - elemento a ser inserido.
	 */
	void addUser(User usr);

	/**
	 * Remove o elemento cujo nome/identificador e igual a name.
	 * Pre: name != null && hasElement(name)
	 * @param name - nome/identificador do elemento a ser removido.
	 */
	void removeUser(String userID);

}
