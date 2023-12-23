/**
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package safedocmanager;


/**
* Interface da classe que gere os documentos e utilizadores do sistema.
*/


import dataStructures.Iterator;
import documents.Document;
import users.User;


public interface SafeDocManager {
	
	/**
	 * Verifica se um Documento e oficial.
	 * Pre: - docName != null && userID != null
	 * @param docName - nome do documento.
	 * @param userID  - identificador do dono do documento.
	 * @return - devolve true se o documento for oficial.
	 */
	boolean isOfficialDoc(String docName, String userID);
	
	/**
	 * Verfica se um utilizador e um Clerk.
	 * Pre: - userID != null
	 * @param userID - identificador do utilizador.
	 * @return - devolve true se o utilizador for um Clerk.
	 */
	boolean isClerk(String userID);
	
	/**
	 * Verifica se um grant de um utilizador ja foi revocado.
	 * Pre: - docName != null && managerID != null && otherUserID!= null
	 * @param docName - nome do documento.
	 * @param managerID - identificador do dono documento.
	 * @param otherUserID - identificador do documento.
	 * @return - devolve true se o grant ja foi revocado.
	 */
	boolean isRevoked(String docName, String managerID, String otherUserID);
	
	/**
	 * Verifica se existe um utilizador no sistema.
	 * Pre: - ide!=null
	 * @param id - identificador do utilizador.
	 * @return - devolve true se o utilizador existir.
	 */
	boolean hasUser(String id);
	
	/**
	 * Verifica se um utilizador tem um certo documento.
	 * Pre: - docName != null && managerID != null
	 * @param docName - nome do documento.
	 * @param managerID - identificador do dono documento.
	 * @return - devolve true se o utilizador tiver o documento.
	 */
	boolean hasDoc(String docName, String managerID);
	
	/**
	 * Verifica se um utilizador tem um nivel de seguranca necessario.
	 * Pre: - userID != null && securityLevel != null
	 * @param userID - identificador do documento.
	 * @param securityLevel - nivel de seguranca requerido.
	 * @return - devolve true se o utilizador tiver um nivel de seguranca igual ou acima.
	 */
	boolean hasClearance(String userID, String securityLevel);
	
	/**
	 * Verifica se um utilizador tem grant a um dado documento.
	 * Pre: - docName != null && managerID != null otherUserID != null
	 * @param docName - identificador do documento.
	 * @param managerID - identificador do dono do documento.
	 * @param otherUserID - identificador do utilizador em questao.
	 * @return - devolve true se o utilizador tem grant ao documento.
	 */
	boolean hasGrant(String docName, String managerID, String otherUserID);
	
	/**
	 * Devolve o nivel de seguranca de um dado documento.
	 * Pre: - docName != null && managerID != null
	 * @param docName - nome do documento.
	 * @param managerID - identificador do dono do documento.
	 * @return - devolve o nivel de seguranca do documento.
	 */
	String getDocSecurityLevel(String docName, String managerID);
	
	/**
	 * Regista um novo utilizador no sistema.
	 * Pre: - userType != null && id != null securityLevel != null
	 * @param userType - tipo de utilizador.
	 * @param id - identificador do utilizador.
	 * @param securityLevel - nivel de seguranca do utilizador.
	 */
	void register(String userType, String id, String securityLevel);
	
	/**
	 * Lista todos os utilizadores no sistema.
	 * @return - Devolve um objeto Iterator do tipo User.
	 */
	Iterator<User> listUsers();
	
	/**
	 * Regista um novo documento no sistema e guarda o documento na colecao de documentos
	 * do utilizador que fez upload do documento.
	 * Pre: - docName != null && userID != null securityLevel != null && description != null
	 * @param docName - nome do documento.
	 * @param userID - identificador do utilizador.
	 * @param securityLevel - nivel de seguranca do utilizador.
	 * @param description - descricao do documento.
	 */
	void uploadDoc(String docName, String userID, String securityLevel, String description);
	
	/**
	 * Atualiza os dados de um documento.
	 * Pre: - docName != null && managerID != null && updaterID != null description != null
	 * @param docName - nome do documento.
	 * @param managerID - identificador do dono do documento.
	 * @param updaterID - identificador utilizador que esta a atualizar documento.
	 * @param description - descricao atualizada do documento.
	 */
	void write(String docName, String managerID, String updaterID, String description);
	
	/**
	 * Devolve a descricao do documento.
	 * Pre: - docName != null && managerID != null readerID != null
	 * @param docName - nome do documento.
	 * @param managerID - identificador do dono do documento.
	 * @param readerID - identificador utilizador que esta a ler o documento.
	 * @return - Devolve a descricao do documento.
	 */
	String read(String docName, String managerID, String readerID);
	
	/**
	 * Da acesso a um documento a um utilizador com nivel de seguranca inferior.
	 * Pre: - docName != null && managerID != null
	 * @param docName - nome do documento.
	 * @param managerID - identificador do dono do documento.
	 * @param toBeGrantedID -  identificador do utilizador a receber acesso.
	 */
	void grantAccess(String docName, String managerID, String toBeGrantedID);
	
	/**
	 * Revoca o acesso de um utilizador a um documento.
	 * Pre: - docName != null && managerID != null && toBeRevokedID != null
	 * @param docName - nome do documento.
	 * @param managerID - identificador do dono do documento.
	 * @param toBeRevokedID - identificador do utilizador a perder acesso.
	 */
	void revokeAccess(String docName, String managerID, String toBeRevokedID);
	
	/**
	 * Lista documentos de um utilizador que tem o seu tipo igual a docType.
	 * Pre: - docName != null 
	 * @param managerID - identificador do dono do documento.
	 * @param docType - tipo de documento.
	 * @return - Devolve um objeto do tipo IteratorWithFilter que recebe um tipo de
	 * documento e lista todos os documentos desse tipo.
	 */
	Iterator<Document> listUserDocs(String managerID, String docType);
	
	/**
	 * Lista documentos que tem o maior numero de grants.
	 * @return - Devolve um objeto Iterator do tipo Document.
	 */
	Iterator<Document> listTopLeaked();
	
	/**
	 * Lista utilizadores que deram o maior numero de grants.
	 * @return - Devolve um objeto Iterator do tipo User.
	 */
	Iterator<User> listTopGranters();
	
}
