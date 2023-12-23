/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package users;


/**
 * Classe de topo que contem todos os metodos e variaveis associados as acoes que 
 * um utilizador pode ter na aplicacao comuns a todas as subclasses de utilizadores 
 * que possam existir ou seja as diferentes variantes de utilizador no caso desta 
 * aplicacao Officer e Clerk.
 */


import collections.DocCollection;
import collections.DocCollectionClass;
import dataStructures.Iterator;
import documents.Document;


public abstract class UserClass implements User {

	/**
	 * Colecao dos documentos do utilizador. 
	 */
	protected DocCollection myDocs;
	
	/**
	 * Tipo do utilizador.
	 */
	protected String kind;
	
	/**
	 * Identificador do utlizador.
	 */
	protected String userID;
	
	/**
	 * Nivel de seguranca do utilizador.
	 */
	protected String securityLevel;
	
	/**
	 * Construtor da classe.
	 * Pre: - userType != null && id != null && clearenceLevel != null
	 * @param userType - tipo de utilizador.
	 * @param id - identificador do utilizador.
	 * @param clearenceLevel - nivel de seguranca de utilizador.
	 */
	protected UserClass(String userType, String id, String clearanceLevel) {
		kind = userType;
		userID = id;
		securityLevel = clearanceLevel;
		myDocs = new DocCollectionClass();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		return userID.equals(obj);
	}
		
	@Override
	public boolean hasDoc(String docName) {
		return myDocs.hasDoc(docName);
	}

	@Override
	public Iterator<Document> getFilteredDocIterator(String docType, String userType) {
		return myDocs.getFilteredIterator(docType, userType);
	}
		
	@Override
	public Document getDoc(String docName) {
		return myDocs.getDoc(docName);
	}
	
	@Override
	public int getNumberOfDocs() {
		return myDocs.getNumberOfDocs();
	}

	@Override
	public void uploadDoc(Document doc) {
		myDocs.addDoc(doc);
	}

	@Override
	public String getID() {
		return userID;
	}
	
	@Override
	public String getKind() {
		return kind;
	}
	
	@Override
	public String getSecurityLevel() {
		return securityLevel;
	}

}
