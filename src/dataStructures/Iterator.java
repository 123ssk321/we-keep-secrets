/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package dataStructures;


/**
 * Interface da classe que representa um iterador generico.
 *
 */


/**
 * @param <E> - tipo generico que posteriormente e substituido porum tipo concreto.
 */
public interface Iterator<E> {
	
	/**
	 * Vai para o comeco da coleccao de elementos.
	 */
	void init();
	
	/**
	 * Verifica se existem mais elementos na colecao a seguir
	 * ao elemento em que esta o iterador.
	 * @return - devolve true se existirem mais elementos na colecao.
	 */
	boolean hasNext();
	
	/**
	 * Devolve o proximo elemento.
	 * @return - proximo elemento.
	 */
	E next();
	
}
