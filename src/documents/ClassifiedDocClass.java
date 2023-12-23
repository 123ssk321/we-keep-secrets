/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package documents;


/**
 * Classe que representa uma variante de Document contendo os metodos e variaveis 
 * associados aos documentos do tipo classified.
 */


import accesshistory.AccessesRecord;
import accesshistory.UnlimitedHistoryClass;
import collections.UserCollection;
import collections.UserCollectionClass;
import dataStructures.Iterator;
import users.User;


public class ClassifiedDocClass extends DocumentClass implements ClassifiedDoc {

	/**
	 * Tipo do documento.
	 */
	private static final String DOC_TYPE = "classified";
	
	/**
	 * Historico de tipos de acessos ao documento.
	 */
	private AccessesRecord accessesTypeHistory;
	
	/**
	 * Historico de acessos cedidos e revocados a utilizadores ao documento.
	 */
	private AccessesRecord grantsHistory;
	
	/**
	 * Numero de vezes que foi cedido acesso a utilizadores com nivel 
	 * inferior ao do documento.
	 */
	private int numberOfLeaks;
	
	/**
	 * Numero de vezes que foi  revocado o acesso cedido a utilizadores 
	 * com nivel inferior ao do documento.
	 */
	private int numberOfRevokeds;
	
	/**
	 * Numero de vezes que a descricao do documento foi modificada.
	 */
	private int numberOfUpdates;
	
	/**
	 * Colecao de utilizadores com grants.
	 */
	private UserCollection granteds;
	
	/**
	 * Colecao de utilizadores cuja grant foi revocada.
	 */
	private UserCollection revokeds;

	
	/**
	 * Construtor da classe que envoca o construtor da superclasse e
	 * inicializa as variaveis de instancia pertencentes a esta classe com os parametros recebidos. 
	 * Pre: - name != null && manager != null && accessLevel != null && description != null
	 * @param name - nome do documento.
	 * @param manager - identificador do dono do documento.
	 * @param accessLevel - nivel de seguranca do documento.
	 * @param description - descricao do documento.
	 */
	public ClassifiedDocClass(String name, String manager, String accessLevel, String description) {
		super(name, manager, accessLevel, description);
		numberOfLeaks = 0;
		numberOfRevokeds = 0;
		numberOfUpdates = 0;
		grantsHistory = new UnlimitedHistoryClass();
		accessesTypeHistory = new UnlimitedHistoryClass();
		granteds = new UserCollectionClass();
		revokeds = new UserCollectionClass();
	}

	
	@Override
	public boolean hasGrant(String userID) {
		return granteds.hasUser(userID); 
	}

	@Override
	public boolean hasRevoke(String userID) {
		return revokeds.hasUser(userID);
	}		
	
	@Override
	public Iterator<String> getInfoGrantsIterator() {
		return grantsHistory.getInfoIterator();
	}

	@Override
	public Iterator<User> getUserGrantsIterator() {
		return grantsHistory.getUserIterator();
	}

	@Override
	public Iterator<String> getInfoAccessesIterator() {
		return accessesTypeHistory.getInfoIterator();
	}
	
	@Override
	public Iterator<User> getUserAccessesIterator() {
		return accessesTypeHistory.getUserIterator();
	}
	
	@Override
	public int getNumberOfUpdates() {
		return numberOfUpdates;
	}
	
	@Override
	public int getNumberOfLeaks() {
		return numberOfLeaks;
	}
	
	@Override
	public int getNumberOfRevokeds() {
		return numberOfRevokeds;
	}
		
	@Override
	public void addGrantedUser(User usr) {
		grantsHistory.addToHistory(usr, "grant");
		granteds.addUser(usr);
		numberOfLeaks++;
	}

	@Override
	public void addRevokedUser(User usr) {
		grantsHistory.addToHistory(usr, "revoked");
		revokeds.addUser(usr);
		granteds.removeUser(usr.getID());
		numberOfRevokeds++;
	}

	@Override
	public void update(User writer, String description) {
		super.description = description;
		accessesTypeHistory.addToHistory(writer, "write");
		numberOfUpdates++;
		super.numberOfAccesses++;
	}
		
	@Override
	public String getDescription(User reader) {
		numberOfAccesses++;
		super.numberOfReadAccesses++;
		accessesTypeHistory.addToHistory(reader, "read");
		return super.description;
	}
	
	@Override
	public String getDocType() {
		return DOC_TYPE;
	}

}
