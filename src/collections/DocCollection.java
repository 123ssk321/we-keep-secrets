/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package collections;


/**
 * Interface da classe que representa uma colecao de objetos do tipo Document. 
 */


import dataStructures.Iterator;
import documents.Document;


public interface DocCollection {

	/**
	 * Verifica se um elemento com o nome/identificador igual
	 * a name existe na colecao.
	 * Pre: - name != null
	 * @param name - nome/identificador do elemento.
	 * @return - devolve true se o elemento existir na colecao.
	 */
	boolean hasDoc(String docName);

	/**
	 * Devolve o elemento que tem o nome/identificador igual
	 * a name.
	 * Pre: - name != null && hasElement(name)
	 * @param name - nome/identificador do elemento.
	 * @return - elemento com o nome/identificador igual a name.
	 */
	Document getDoc(String docName);

	/**
	 * Devolve um objeto do tipo Iterator que itera sobre documentos com o tipo
	 * igual a docType e o retorno depedente do userType ou seja para um Officer devolve um iterador com 
	 * documentos filtrados ou seja documentos com o tipo igual a docType enquanto 
	 * que para um Clerk devolve um iterador nao filterado.
	 * @return - objeto do tipo Iterator.
	 */
	Iterator<Document> getFilteredIterator(String docType, String userType);
		
	/**
	 * Ordena a colecao de documentos do tipo ClassifiedDoc
	 * por ordem decrescente do numero de acessos cedidos 
	 * (grants) a utilizadores de nivel inferior ao 
	 * documento de cada documento atraves da criacao de um novo
	 * objeto do tipo DocumentCollection onde vao ser inseridos ordenadamente
	 * os documentos, retornando o iterador dessa colecao temporaria de
	 * documentos. 
	 * Utiliza o metodo insertion sort.
	 * @return - objeto do tipo Iterator.
	 */
	Iterator<Document> getSortedIterator();

	/**
	 * Devolve o numero de elementos da colecao. 
	 * @return - numero de elementos da colecao.
	 */
	int getNumberOfDocs(); 

	/**
	 * Adiciona o elemento na proxima posicao livre da colecao.
	 * Pre: - elm != null
	 * @param elm - elemento a ser inserido.
	 */
	void addDoc(Document doc);

}
