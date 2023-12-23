/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package dataStructures;


/**
 * Classe que contem os metodos necessario para iterar sobre os elementos de um vetor.
 *
 */


/**
 * @param <E> - tipo generico que posteriormente e substituido porum tipo concreto.
 */
public class IteratorClass<E> implements Iterator<E> {
	
	/**
	 * Vetor/colecao de elementos.
	 */
	private E[] elems;
	
	/**
	 * Numero de elementos da colecao.
	 */
	private int counter;
	
	/**
	 * Indice do elemento em que o iterador esta.
	 */
	private int current;

	
	/**
	 * Construtor da classe.
	 * Inicializa as variaveis de instancia.
	 * @param array - colecao de elementos que vai ser iterada.
	 * @param counter - numero de elementos da colecao.
	 */
	public IteratorClass(E[] array, int counter) {
		this.elems = array;
		this.counter = counter;
	}

	
	@Override
	public void init() {
		current = 0;
	}

	@Override
	public boolean hasNext() {
		return current < counter;
	}

	@Override
	public E next() {
		return elems[current++];
	}
	
}
