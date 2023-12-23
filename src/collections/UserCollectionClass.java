/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package collections;


/*
 * Classe representa uma colecao de utilizadores e que contem os metodos asssociados
 * a uma colecao de objetos do tipo User.
 */


import dataStructures.Collection;

/**
 * Subclasse de CollectionClasss que contem uma colecao de objetos do tipo User e os metodos asssociados 
 * a colecao provenientes da superclasse e o metodo de ordenacao de um vetor que pertence a subclasse.
 */



import dataStructures.CollectionClass;
import dataStructures.Iterator;
import users.Officer;
import users.User;


public class UserCollectionClass implements UserCollection {

	/**
	 * Objeto que contem um vetor de User
	 * e os metodos associados ao vetor.
	 */
	private Collection<User> users;


	/**
	 * Construtor da classe.
	 * Inicializa o objeto users.
	 */
	public UserCollectionClass() {
		users = new CollectionClass<User>();
	}


	@Override
	public boolean hasUser(String userID) {
		return users.hasElement(userID);
	}

	@Override
	public User getUser(String userID) {
		return users.getElement(userID);
	}
	
	@Override
	public Iterator<User> getIterator() {
		return users.getIterator();
	}
	
	@Override
	public Iterator<User> getSortedIterator() {
		Iterator<User> it1 = users.getIterator();
		it1.init();

		//novo objeto que contem o vetor onde serao inseridos os utilizadores de forma ordenada
		CollectionClass<User> tmp = new CollectionClass<User>();

		while(it1.hasNext()) {
			//utilizador que vai ser inserido ordenadamente num novo vetor de utilizadores.
			User user1 = it1.next();
			
			if(tmp.getNumberOfElements() == 0) {
				tmp.add(user1);
			}
			else {
				int i = 0;
				int pos = -1;
				
				//cria um novo iterador com o vetor de utilizadores atualizado
				Iterator<User> it2 = tmp.getIterator();
				it2.init();
				
				while(it2.hasNext() && pos == -1) {
					//utilizadores que ja forma inseridos no novo vetor
					User user2 = it2.next();

					//os atributos dos utilizadores que estabelecem os criterios de ordenacao
					int n1 = ((Officer)user1).getNumberOfGrants();
					int n2 = ((Officer)user2).getNumberOfGrants();

					String s1 = ((Officer)user1).getID();
					String s2 = ((Officer)user2).getID();

					//encontra o primeiro elemento que tem o numero de grants inferior ao utilizador que vai ser inserido
					//ou tem o mesmo numero de grants mas esta abaixo alfabeticamente guardando a sua posicao para o 
					//utilizador a ser inserido ser inserido nessa posicao
					if(n1 > n2 || (n1 == n2 && s1.compareTo(s2) < 0)) {
						pos = i;
					}
					else {
						i++;
					}
				}
				//se todos os utilizadores no novo vetor tiverem o numero de grants superior ou tiverem o identificador
				//acima alfabeticamente entao o utilizador a ser inserido e inserido na ultima posicao livre
				if(pos == -1) {
					pos = tmp.getNumberOfElements();
				}
				tmp.insertAt(user1, pos);
			}
		}
		return tmp.getIterator();
	}

	@Override
	public void addUser(User usr) {
		users.add(usr);
	}

	@Override
	public void removeUser(String userID) {
		users.remove(userID);;
	}

}
