/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package users;


/**
 * Interface da classe que representa um utilizador na aplicacao.
 */


import dataStructures.Iterator;
import documents.Document;


public interface User  {
	
	/**
	 * Redefine o metodo original da superclasse Object
	 * Verifica se obj e igual a uma variavel de instancia (neste caso, a userID) de User.
	 * Nesta aplicacao obj sera sempre do tipo String por isso nao contem as verificacoes standard
	 * do metodo original.
	 * Pre: - obj != null
	 * @param obj - objeto a ser comparado.
	 * @return true se a variavel for igual a obj.
	 */
	@Override
	boolean equals(Object obj);
	
	/**
	 * Verifica se o utilizador tem o documento com o nome dado.
	 * Pre: - docName != null
	 * @param docName - nome do documento.
	 * @return - devolve true se o utilizador tiver o documento.
	 */
	boolean hasDoc(String docName);
	
	/**
	 * Devolve um iterador de documentos dependente do tipo de utilizador.
	 * Para um Officer devolve um iterador com documentos filtrados ou seja documentos
	 * com o tipo igual a docType enquanto para um Clerk devolve um iterador nao filterado.
	 * Pre: - docType != null && user != null
	 * @param docType - Tipo de documento.
	 * @param userTypr - Tipo de utilizador.
	 * @return - Iterador de documentos.
	 */
	Iterator<Document> getFilteredDocIterator(String docType, String userType);
	
	/**
	 * Devolve o documento com o nome igual a docName.
	 * Pre: - hasDoc(docName) && docName != null
	 * @param docName - nome do documento.
	 * @return - documento com o nome igual a docName.
	 */
	Document getDoc(String docName);
	
	/**
	 * Devolve o numero de documentos do utilizador.
	 * @return - numero de documentos. 
	 */
	int getNumberOfDocs();
	
	/**
	 * Guarda o doc na colecao de documentos do utilizador.
	 * Pre: - doc != null
	 * @param doc - objeto do tipo Document. 
	 */
	void uploadDoc(Document doc);
	
	/**
	 * Devolve o identificador do utilizador.
	 * @return - identificador do utilizador.
	 */
	String getID();
	
	/**
	 * Devolve o tipo de utilizador.
	 * @return - tipo de utilizador.
	 */
	String getKind();
	
	/**
	 * Devolve o nivel de seguranca do utilizador.
	 * @return - nivel de seguranca do utilizador.
	 */
	String getSecurityLevel();
	
}
