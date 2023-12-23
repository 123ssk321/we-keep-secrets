/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package users;


/**
 * Classe que representa uma variante de User contendo os metodos e variaveis 
 * associados as acoes que um utilizador do tipo Officer possa ter na aplicacao.
 */


import documents.ClassifiedDoc;


public class OfficerClass extends UserClass implements Officer {

	/**
	 * Numero de grants cedidos.
	 */
	private int numberOfGrants;
	
	/**
	 * Numero de grants revocados.
	 * 
	 */
	private int numberOfRevokes;

	
	/**
	 * Construtor da classe que envoca o construtor da superclasse e
	 * inicializa as variaveis de instancia pertencentes a esta classe com os parametros recebidos. 
	 * Pre: userType != null && id != null && clearenceLevel != null
	 * @param userType - tipo do utilizador.
	 * @param id - identificador do utilizador.
	 * @param clearanceLevel - nivel de seguranca do utilizador.
	 */
	public OfficerClass(String userType, String id, String clearanceLevel) {
		super(userType, id, clearanceLevel);
		numberOfGrants = 0;
		numberOfRevokes = 0;
	}

	
	@Override
	public boolean hasGrant(String userID, String docName) {
		return ((ClassifiedDoc)super.myDocs.getDoc(docName)).hasGrant(userID);
	}

	@Override
	public int getNumberOfGrants() {
		return numberOfGrants;
	}
	
	@Override
	public int getNumberOfRevokes() {
		return numberOfRevokes;
	}
	
	@Override
	public void giveGrant(String docName, User toBeGrantedUser) {
		((ClassifiedDoc)super.myDocs.getDoc(docName)).addGrantedUser(toBeGrantedUser);;
		numberOfGrants++;
	}
	
	@Override
	public void revokeGrant(String docName, User toBeRevokedUser) {
		((ClassifiedDoc)super.myDocs.getDoc(docName)).addRevokedUser(toBeRevokedUser);;
		numberOfRevokes++;
	}
	
}
