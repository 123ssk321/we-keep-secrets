/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package accesshistory;


/**
 * Subclasse de AccessesRecordClass que contem o historico
 * da superclasse mas ilimitado ou seja guarda toda a informacao
 * e todos os utilizadores desde que um documento foi carregado no sistema.
 */


import users.User;


public class UnlimitedHistoryClass extends AccessesRecordClass {

	
	/**
	 * Construtor da classe que envoca o construtor da superclasse.
	 */
	public UnlimitedHistoryClass() {
		super();
	}

	
	@Override
	public void addToHistory(User usr, String info) {
		if(super.isFull()) {
			resize(super.users);
			resize(super.info);
		}
		super.info[counter] = info;
		super.users[counter++] = usr;
	}	
	
	/**
	 * Aumenta a capacidade maxima da colecao quando esta atinge 
	 * o limite maximo de armazenamento de elementos.
	 */
	@SuppressWarnings("unchecked")
	private<E> void resize(E[] array) {
		E tmp[] = (E[]) new Object[GROWTH * array.length];
		for (int i = 0; i < super.counter; i++) {
			tmp[i] = array[i];
		}
		array = tmp;
	}
	
}
