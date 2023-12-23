/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package safedocmanager;


/**
* Classe de topo que gere os documentos e utilizadores do sistema.
*/


import collections.*;
import dataStructures.Iterator;
import documents.ClassifiedDoc;
import documents.ClassifiedDocClass;
import documents.Document;
import documents.OfficialDocClass;
import users.ClerkClass;
import users.Officer;
import users.OfficerClass;
import users.User;


public class SafeDocManagerClass implements SafeDocManager {

	/**
	 * Colecao dos utilizadores.
	 */
	private UserCollection users;
	
	/**
	 * Colecao dos utilizadoes que deram o maior numero de grants.
	 */
	private UserCollection topGranters;
	
	/**
	 * Colecao dos documentos que foram cedidos mais vezes.
	 */
	private DocCollection topLeaked;
	
	
	/**
	 * Construtor da classe.
	 * Inicializa as variaveis de instancia.
	 */
	public SafeDocManagerClass() {
		users = new UserCollectionClass();
		topGranters = new UserCollectionClass();
		topLeaked = new DocCollectionClass();
	}
	
	
	@Override
	public boolean isOfficialDoc(String docName, String userID) {
		return users.getUser(userID).getDoc(docName).getDocType().equals("official");
	}

	@Override
	public boolean isClerk(String userID) {
		return users.getUser(userID).getKind().equals("clerk");
	}
		
	@Override
	public boolean isRevoked(String docName, String managerID, String otherUserID) {
		return ((ClassifiedDoc)users.getUser(managerID).getDoc(docName)).hasRevoke(otherUserID) ;
	}
	
	@Override
	public boolean hasUser(String id) {
		return users.hasUser(id);
	}
	
	@Override
	public boolean hasDoc(String docName, String managerID) {
		return users.getUser(managerID).hasDoc(docName);
	}
	
	@Override
	public boolean hasClearance(String userID, String securityLevel) {
		SecurityLevels level1 = SecurityLevels.getSecurityLevel(users.getUser(userID).getSecurityLevel());
		SecurityLevels level2 = SecurityLevels.getSecurityLevel(securityLevel);
		return level1.isSuperiorThan(level2);
	}

	@Override
	public boolean hasGrant(String docName, String managerID, String otherUserID) {
		return ((ClassifiedDoc)users.getUser(managerID).getDoc(docName)).hasGrant(otherUserID) ;
	}
	
	@Override
	public String getDocSecurityLevel(String docName, String managerID) {
		return users.getUser(managerID).getDoc(docName).getAccessLevel().toLowerCase();
	}
	
	@Override
	public void register(String userType, String id, String securityLevel) {
		User usr = null;
		if(securityLevel.equalsIgnoreCase("Clerk")) {
			usr = new ClerkClass(userType, id, securityLevel);
		} 
		else {
			usr = new OfficerClass(userType, id, securityLevel);
		}
			users.addUser(usr);
	}
		
	@Override
	public Iterator<User> listUsers() {
		return users.getIterator();
	}
	
	@Override
	public void uploadDoc(String docName, String userID, String securityLevel, String description) {
		Document doc = null;
		if(securityLevel.equals("official")) {
			doc = new OfficialDocClass(docName, userID, securityLevel, description); 
		} 
		else {
			doc = new ClassifiedDocClass(docName, userID, securityLevel, description);
		}
			users.getUser(userID).uploadDoc(doc);
	}
	
	@Override
	public void write(String docName, String managerID, String updaterID, String description) {
		((ClassifiedDoc)users.getUser(managerID).getDoc(docName)).update(users.getUser(updaterID), description);
	}
	
	@Override
	public String read(String docName, String managerID, String readerID) {
		return users.getUser(managerID).getDoc(docName).getDescription(users.getUser(readerID));
	}
	
	@Override
	public void grantAccess(String docName, String managerID, String toBeGrantedID) {
		((Officer)users.getUser(managerID)).giveGrant(docName, users.getUser(toBeGrantedID));
		if(!topGranters.hasUser(managerID)) {
			topGranters.addUser(users.getUser(managerID));
		}
		if(!topLeaked.hasDoc(docName)) {
			topLeaked.addDoc(((ClassifiedDoc)users.getUser(managerID).getDoc(docName)));
		}
	}

	@Override
	public void revokeAccess(String docName, String managerID, String toBeRevokedID) {
		((Officer)users.getUser(managerID)).revokeGrant(docName, users.getUser(toBeRevokedID));
	}

	@Override
	public Iterator<Document> listUserDocs(String managerID, String docType) {
		if(this.isClerk(managerID)) {
			return users.getUser(managerID).getFilteredDocIterator(docType, "clerk");
		}
		else {
			return users.getUser(managerID).getFilteredDocIterator(docType, "official");
		}
	}
	
	@Override
	public Iterator<Document> listTopLeaked() {
		return topLeaked.getSortedIterator();
	}

	@Override
	public Iterator<User> listTopGranters() {
		return topGranters.getSortedIterator();
	}
	
}
