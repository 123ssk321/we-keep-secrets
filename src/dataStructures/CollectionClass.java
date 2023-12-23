/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package dataStructures;


/** 
 * Classe que contem um vetor generico e os metodos associados ao vetor
 * como inserir e remover elementos do vetor. 
 * 
 */


/**
 * @param <E> - tipo generico que posteriormente e substituido porum tipo concreto.
 */
public class CollectionClass<E> implements Collection<E> {

	/**
	 * Tamanho da colecao/capacidade maxima de armazenamento de elementos.
	 */
	protected static final int DEFAULT_SIZE = 10;
	
	/**
	 * Fator de crescimento do vetor.
	 */
	protected static final int GROWTH = 2;
	
	/**
	 * Vetor/colecao de elementos.
	 */
	protected E[] collection;
	
	/**
	 * Numero de elementos na colecao.
	 */
	protected int counter;

	
	/**
	 * Construtor da classe.
	 * Inicializa as variaveis de instancia.
	 */
	@SuppressWarnings("unchecked")
	public  CollectionClass() {
		collection = (E[]) new Object[DEFAULT_SIZE];
		counter = 0;
	}
	
	
	@Override
	public boolean hasElement(String name) {
		return getIndexOf(name) >= 0;
	}
	
	@Override
	public E getElement(String name) {
		return collection[getIndexOf(name)];
	}
	
	@Override
	public int getNumberOfElements() {
		return counter;
	}

	@Override
	public Iterator<E> getIterator() {
		return new IteratorClass<E>(collection, counter);

	}
		
	@Override
	public void add(E elm) {
		if (isFull()) { 
			resize();
		}
		collection[counter++] = elm;
	}
	
	@Override
	public void insertAt(E e, int pos) {
		if (counter == collection.length) {
			resize();
		}
		for(int i = counter-1; i >= pos; i--) {
			collection[i+1] = collection[i];
		}
		collection[pos] = e;
		counter++;
	}
	
	@Override
	public void remove(String name) {
		int pos = getIndexOf(name);
		for(int i = pos; i< counter -1; i++)
			collection[i] = collection[i+1];
		collection[--counter] = null;
	}
	
	/**
	 * Verifica se a colecao esta cheia.
	 * @return - devolve true se a colecao tiver atingido o limite maximo.
	 */
	private boolean isFull() {
		return collection.length == counter;
	}
	
	/**
	 * Devolve o indice do elemento cujo nome/identificador
	 * e igual a name.
	 * Pre: - name !=  null
	 * @param name - nome/identificador do elemento.
	 * @return - indice do elemento. 
	 */
	private int getIndexOf(String name) {
		int i = 0;
		int result = -1;
		boolean found = false;
		while (i<counter && !found)
			if (collection[i].equals(name)) {
				found = true;
				result = i;
			}
			else {
				i++;
			}
		return result;
	}
	
	/**
	 * Aumenta a capacidade maxima da colecao quando esta atinge 
	 * o limite maximo de armazenamento de elementos.
	 */
	@SuppressWarnings("unchecked")
	protected void resize() {
		E tmp[] = (E[]) new Object[GROWTH * collection.length];
		for (int i=0;i<counter; i++) {
			tmp[i] = collection[i];
		}
		collection = tmp;
	}
	
}
