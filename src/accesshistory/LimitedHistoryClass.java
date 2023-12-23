/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package accesshistory;


/**
 * Subclasse de AccessesRecordClass que contem o historico
 * da superclasse mas limitado ou seja apenas guarda informacao
 * e utilizadores ate 10 elementos. Os elementos que estao no vetor
 * a mais tempo sao eliminados guardando os elemento mais recentes.
 */


import users.User;


public class LimitedHistoryClass extends AccessesRecordClass {

	
	/**
	 * Construtor da classe que envoca o construtor da superclasse.
	 */
	public LimitedHistoryClass() {
		super();
	}

	
	public void addToHistory(User usr, String info) {
		if(super.isFull()) {
			move(super.users, super.counter - 2);
			move(super.info, super.counter - 2);
			super.users[0] = usr;
			super.info[0] = info;
		}
		else {
			move(super.users, super.counter - 1);
			move(super.info, super.counter - 1);
			super.users[0] = usr;
			super.info[0] = info;
			super.counter++;
		}
	}
	
	/**
	 * Move os elementos da colecao para o indice a sua frente ou seja
	 * para a direita.
	 * Pre: - array != null && c != null
	 * @param array - colecao que vai ser movida.
	 * @param count - numero de elementos da colecao.
	 */
	private<E> void move(E[] array, int count) {
		if(count >= 0) {
			for(int i = count; i >= 0 ;i--) {
				array[i + 1] = array[i];
			}
		}
	}
	
}
