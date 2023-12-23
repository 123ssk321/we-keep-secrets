/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package accesshistory;


/**
 * Classe que contem um vetor de objetos do tipo User e um vetor de String 
 * para guardar os utilizadores e a informacao relacionada.
 * Nesta aplicacao e apenas guardada a informacao relacionada com o tipo de acesso
 * e os utilizadores com tem grant ou revoke ao documento. 
 */


import dataStructures.Iterator;
import dataStructures.IteratorClass;
import users.User;
import users.UserClass;


public abstract class AccessesRecordClass implements AccessesRecord {

	/**
	 * Tamanho original do vetor.
	 */
	protected static final int DEFAULT_SIZE = 10; 
	
	/**
	 * Fator crescimento do vetor.
	 */
	protected static final int GROWTH = 2;
	
	/**
	 * Numero de elementos da colecao.
	 */
	protected int counter;
	
	/**
	 * Vetor de informacao de utilizadores.
	 */
	protected String info[];
	
	/**
	 * Vetor de utilizadores.
	 */
	protected User users[];

	
	/**
	 * Construtor da classe.
	 * Inicializa as variaveis de instancias.
	 */
	protected AccessesRecordClass() {
		counter = 0;
		info = new String [DEFAULT_SIZE];
		users = new UserClass[DEFAULT_SIZE];
	}

	
	@Override
	public boolean hasUser(String userID) {
		return getIndexOf(userID) >= 0;
	}
	
	@Override
	public int getNumberOfUsers() {
		return counter;
	}
		
	@Override
	public Iterator<String> getInfoIterator() {
		return new IteratorClass<String>(info,counter);
	}
	
	@Override
	public Iterator<User> getUserIterator() {
		return new IteratorClass<User>(users,counter);
	}

	@Override
	public abstract void addToHistory(User usr, String info);
	
	@Override
	public String getUserInfo(String userID) {
		return info[getIndexOf(userID)];
	}
	
	@Override
	public User getUser(String userID) {
		return users[getIndexOf(userID)];
	}
	
	/**
	 * Devolve o indice do utilizador cujo identificador
	 * e igual a id.
	 * Pre: - id !=  null
	 * @param id - nome/identificador do elemento.
	 * @return - indice do utilizador. 
	 */
	private int getIndexOf(String id) {
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i<counter && !found)
			if (users[i].getID().equals(id))
				found = true;
			else
				i++;
		if (found) result = i;
		return result;
	}
	
	/**
	 * Verifica se a colecao esta cheia.
	 * @return - devolve true se a colecao tiver atingido o limite maximo.
	 */
	protected boolean isFull() {
		return counter == info.length;
	}

}
