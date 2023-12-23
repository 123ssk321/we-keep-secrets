/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package dataStructures;


/**
 * Interface da classe que contem os metodos associados a um vetor.
 *  
 */


/**
 * @param <E> - tipo generico que posteriormente e substituido porum tipo concreto.
 */
public interface Collection<E> {
	
	/**
	 * Verifica se um elemento com o nome/identificador igual
	 * a name existe na colecao.
	 * Pre: - name != null
	 * @param name - nome/identificador do elemento.
	 * @return - devolve true se o elemento existir na colecao.
	 */
	 boolean hasElement(String name);
	
	 /**
	  * Devolve o elemento que tem o nome/identificador igual
	  * a name.
	  * Pre: - name != null && hasElement(name)
	  * @param name - nome/identificador do elemento.
	  * @return - elemento com o nome/identificador igual a name.
	  */
	 E getElement(String name);
	 
	 /**
	  * Devolve um iterador dos elemntos da colecao.
	  * @return - iterador de elementos da colecao.
	  */
	 Iterator<E> getIterator();
	 
	 /**
	  * Devolve o numero de elementos da colecao.
	  * @return - numero de elementos da colecao.
	  */
	 int getNumberOfElements(); 

	 /**
	  * Adiciona o elemento na proxima posicao livre da colecao.
	  * Pre: - elm != null
	  * @param elm - elemento a ser inserido.
	  */
	 void add(E elm);

	 /**
	  * Insere o elemento <code>e</code> na posicao <code>pos</code> do vector
	  * @param e elemento a inserir no vector
	  * @param pos posicao do vector a inserir o elemento
	  * @pre pos < size()
	  */
	 void insertAt(E elm, int pos);
	 
	 /**
	  * Remove o elemento cujo nome/identificador e igual a name.
	  * Pre: - name != null && hasElement(name)
	  * @param name - nome/identificador do elemento a ser removido.
	  */
	 void remove(String name);
	 
}
