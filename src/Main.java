/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

import java.util.Scanner;

import dataStructures.Iterator;
import documents.ClassifiedDoc;
import documents.Document;
import documents.OfficialDoc;
import safedocmanager.*;
import users.Officer;
import users.User;


/**
* Classe de topo que recebe os comandos e processa os usando a classe SafeDocManager e retornando o feedback de cada comando.
*/


public class Main {

	/**
	 * Comandos do utilizador.
	 */
	private static final String REGISTER          = "REGISTER";
	private static final String LIST_USERS        = "LISTUSERS";
	private static final String UPLOAD            = "UPLOAD";
	private static final String READ              = "READ";
	private static final String WRITE             = "WRITE";
	private static final String GRANT_ACCESS      = "GRANT";
	private static final String REVOKE_ACCESS     = "REVOKE";
	private static final String LIST_USER_DOCS    = "USERDOCS";
	private static final String LIST_TOP_LEAKED   = "TOPLEAKED";
	private static final String LIST_TOP_GRANTERS = "TOPGRANTERS";
	private static final String HELP              = "HELP";
	private static final String EXIT              = "EXIT";

	/**
	 * Feedback dado pelo programa.
	 */
	private static final String REGISTER_SUCCESS      = "User %s was registered.\n"; // %s: id do utilizador
	private static final String EXISTING_ID           = "Identifier %s is already assigned to another user.\n"; // %s: id do utilizador
	private static final String DOC_UPLOADED          = "Document %s was uploaded.\n"; // %s: nome do documento
	private static final String DUPLICATE_DOC         = "Document %s already exists in the user account.\n"; // %s: nome do documento
	private static final String DOC_UPDATED           = "Document %s was updated.\n"; // %s: nome do documento
	private static final String NO_DOC                = "Document %s does not exist in the user account.\n"; // %s: nome do documento
	private static final String NO_UPDATE             = "Document %s cannot be updated.\n"; // %s: nome do documento
	private static final String DOC                   = "Document: %s\n"; // %s: conteudo do documento
	private static final String ACCESS_GRANTED        = "Access to document %s has been granted.\n"; // %s: nome do documento
	private static final String HAS_ACCESS            = "Already has access to document %s.\n"; // %s: nome do documento
	private static final String ACCESS_REVOKED        = "Access to document %s has been revoked.\n"; // %s: nome do documento
	private static final String NO_GRANT              = "Grant for %s does not exist.\n"; // %s: id do utilizador
	private static final String GRANT_ALREADY_REVOKED = "Grant for officer %s was already revoked.\n"; // %s: id do utilizador
	private static final String NO_TYPE_DOCS          = "There are no %s documents.\n"; // %s: tipo de documento

	private static final String NO_REGISTERED_USERS   = "There are no registered users.";
	private static final String LOWER_CLEARANCE       = "Insufficient security clearance.";
	private static final String NOT_REGISTERED        = "Not a registered user.";
	private static final String GRANT_NOT_ALLOWED     = "Grants can only be issued between officers.";
	private static final String NO_ACCESSES           = "There are no accesses.";
	private static final String NO_GRANTS             = "There are no grants.";
	private static final String NO_CLEARANCE          = "Inappropriate security level.";
	private static final String NO_LEAKED_DOCUMENTS   = "There are no leaked documents.";
	private static final String NO_GIVEN_GRANTS       = "No officer has given grants.";
	private static final String UNKNOWN_CMD           = "Unknown command. Type help to see available commands.";
	private static final String EXITING               = "Bye!";



	/**
	 * Leitor de comandos introduzidos pelo utilizador.
	 * Pre: in != null
	 * @param in - permite ler os comandos introduzidos pelo utilizador.
	 * @return - comando (String) introduzida pelo utilizador. 
	 */	
	private static String getCommand(Scanner in) {
		//System.out.print("> ");
		return in.nextLine().toUpperCase();
	}

	/**
	 * Intrepretador de comandos do programa.
	 * Os parametros in e dManager sao passados aos varios metodos auxiliares que processao os comandos
	 * do sistema logo as pre condicoes estendem se aos metodos auxiliares.
	 * Pre: cmd != null && in != null && dManager != null
	 * @param cmd - comando introduzido pelo utilizador.
	 * @param in - passado como parametro nos metedos que executam o comando introduzido pelo utilizador permitindo ler
	 * os dados introduzidos.
	 * @param dManager - objeto do tipo SafeDocManager suporta as acoes dos comandos.
	 */
	private static void executeCommand(String cmd, Scanner in, SafeDocManager dManager) {
		switch(cmd) {
		case REGISTER:
			processRegister(in, dManager);
			break;
		case LIST_USERS:
			processListUsers(dManager);
			break;
		case UPLOAD:
			processUpload(in, dManager);
			break;
		case READ:
			processRead(in, dManager);
			break;
		case WRITE:
			processWrite(in, dManager);
			break;
		case GRANT_ACCESS:
			processGrantAccess(in, dManager);
			break;
		case REVOKE_ACCESS:
			processRevokeAccess(in, dManager);
			break;
		case LIST_USER_DOCS:
			processListUserDocs(in, dManager);
			break;
		case LIST_TOP_LEAKED:
			processListTopLeaked(dManager);
			break;
		case LIST_TOP_GRANTERS:
			processListTopGranters(dManager);
			break;
		case HELP:
			processHelp(dManager);
			break;
		default:
			System.out.println(UNKNOWN_CMD);
		}
	}

	/*
	 * Cada metodo executa o comando do programa correspondente.
	 */

	/**
	 * Comando que se usa para registar um novo utilizador no sistema.
	 * Pre: - userType != null && userID != null && securityLevel != null
	 * @param in - o input de onde os dados vao ser lidos.
	 * @param dManager- o SafeDocManager no qual se atualizam os dados.
	 */
	private static void processRegister(Scanner in, SafeDocManager dManager) {
		String userType = in.next().toLowerCase();
		String userID = in.next();
		String securityLevel = in.nextLine().trim().toLowerCase();

		if(dManager.hasUser(userID)) {
			System.out.printf(EXISTING_ID, userID);
		}
		else {
			System.out.printf(REGISTER_SUCCESS, userID);
			dManager.register(userType, userID, securityLevel);
		}
	}

	/**
	 * Lista todos os utilizadores do sistema.
	 * @param dManager - o SafeDocManager a listar todos os utlizadores no sistema.
	 */
	private static void processListUsers(SafeDocManager dManager) {
		Iterator<User> it = dManager.listUsers();
		it.init();
		if(it.hasNext()) {
			while(it.hasNext()) {
				User usr = it.next();
				System.out.printf("%s %s %s\n", usr.getKind(), usr.getID(), usr.getSecurityLevel());
			}
		}
		else {
			System.out.println(NO_REGISTERED_USERS);
		}
	}
	
	/**
	 * Comando que um utlizador usa para dar upload a um novo documento no sistema.
	 * Pre: - docName != null && userID != null && securityLevel != null
	 * @param in - o input de onde os dados vao ser lidos.
	 * @param dManager- o SafeDocManager no qual se cria o documento.
	 */
	private static void processUpload(Scanner in, SafeDocManager dManager) {
		String docName = in.next();
		String userID = in.next();
		String securityLevel = in.nextLine().trim().toLowerCase();
		String description = in.nextLine().trim();
		
		if(!dManager.hasUser(userID)) {
			System.out.println(NOT_REGISTERED);
		}
		else if(dManager.hasDoc(docName, userID)){
			System.out.printf(DUPLICATE_DOC, docName);
		}
		else if(!dManager.hasClearance(userID, securityLevel)){
			System.out.println(LOWER_CLEARANCE);
		}
		else {
			dManager.uploadDoc(docName, userID, securityLevel, description);
			System.out.printf(DOC_UPLOADED, docName);
		}
	}
	
	/**
	 * Comando que um utlizador usa para escrever num documento.
	 * Pre: - docName != null && managerID != null && updaterID != null
	 * @param in - o input de onde os dados vao ser lidos.
	 * @param dManager- o SafeDocManager no qual se atualizam os dados.
	 */
	private static void processWrite(Scanner in, SafeDocManager dManager) {
		String docName = in.next();
		String managerID = in.next();
		String updaterID = in.nextLine().trim();
		String description = in.nextLine().trim();

		if(!dManager.hasUser(managerID) || !dManager.hasUser(updaterID)) {
			System.out.println(NOT_REGISTERED);
		}
		else if(!dManager.hasDoc(docName, managerID)){
			System.out.printf(NO_DOC, docName);
		}
		else if(dManager.isOfficialDoc(docName, managerID)){
			System.out.printf(NO_UPDATE, docName);
		}
		else if(!dManager.hasClearance(updaterID, dManager.getDocSecurityLevel(docName, managerID)) && !dManager.hasGrant(docName, managerID, updaterID)){
			System.out.println(LOWER_CLEARANCE);
		}
		else {
			dManager.write(docName, managerID, updaterID, description);
			System.out.printf(DOC_UPDATED, docName);
		}
	}

	/**
	 * Comando que um utlizador usa para ler a descricao de um documento.
	 * Pre: - docName != null && managerID != null && readerID != null
	 * @param in - o input de onde os dados vao ser lidos.
	 * @param dManager- o SafeDocManager que devolve a descricao do documento.
	 */
	private static void processRead(Scanner in, SafeDocManager dManager) {
		String docName = in.next();
		String managerID = in.next();
		String readerID = in.nextLine().trim();
		
		if(!dManager.hasUser(managerID) || !dManager.hasUser(readerID)) {
			System.out.println(NOT_REGISTERED);
		}
		else if(!dManager.hasDoc(docName, managerID)){
			System.out.printf(NO_DOC, docName);
		}
		else if(!dManager.hasClearance(readerID, dManager.getDocSecurityLevel(docName, managerID)) && !dManager.hasGrant(docName, managerID, readerID)){
			System.out.println(LOWER_CLEARANCE);
		}
		else {
			System.out.printf(DOC, dManager.read(docName, managerID, readerID));
		}
	}
	
	/**
	 * Comando que um utlizador usa para dar acesso a um outro utilizador com um nivel de seguranca insuficiente.
	 * Pre: - docName != null && managerID != null && toBeRevoked != null
	 * @param in - o input de onde os dados vao ser lidos.
	 * @param dManager - o SafeDocManager no qual se pretende dar o grant.
	 */
	private static void processGrantAccess(Scanner in, SafeDocManager dManager) {
		String docName = in.next();
		String managerID = in.next();
		String toBeGrantedID = in.nextLine().trim();
		
		if(!dManager.hasUser(managerID) || !dManager.hasUser(toBeGrantedID)) {
			System.out.println(NOT_REGISTERED);
		}
		else if(dManager.isClerk(toBeGrantedID)) {
			System.out.println(GRANT_NOT_ALLOWED);
		}
		else if(!dManager.hasDoc(docName, managerID)){
			System.out.printf(NO_DOC, docName);
		}
		else if(dManager.hasGrant(docName, managerID, toBeGrantedID) || dManager.hasClearance(toBeGrantedID, dManager.getDocSecurityLevel(docName, managerID))) {
			System.out.printf(HAS_ACCESS, docName);
		}
		else {
			dManager.grantAccess(docName, managerID, toBeGrantedID);
			System.out.printf(ACCESS_GRANTED, docName);
		}
	}
	
	/**
	 * Comando que um utlizador usa para revocar um grant dado anteriormente.
	 * Pre: - docName != null && managerID != null && toBeRevoked != null
	 * @param in - o input de onde os dados vao ser lidos.
	 * @param dManager- o SafeDocManager no qual se pretende revocar o grant.
	 */
	private static void processRevokeAccess(Scanner in, SafeDocManager dManager) {
		String docName = in.next();
		String managerID = in.next();
		String toBeRevokedID = in.nextLine().trim();
		
		if(!dManager.hasUser(managerID) || !dManager.hasUser(toBeRevokedID)) {
			System.out.println(NOT_REGISTERED);
		}
		else if(dManager.isClerk(toBeRevokedID)) {
			System.out.println(GRANT_NOT_ALLOWED);
		}
		else if(!dManager.hasDoc(docName, managerID)){
			System.out.printf(NO_DOC, docName);
		}
		else if(!dManager.hasGrant(docName, managerID, toBeRevokedID) && !dManager.isRevoked(docName, managerID, toBeRevokedID)) {
			System.out.printf(NO_GRANT, toBeRevokedID);
		}
		else if(dManager.isRevoked(docName, managerID, toBeRevokedID)){
			System.out.printf(GRANT_ALREADY_REVOKED, toBeRevokedID);
		}
		else {
			dManager.revokeAccess(docName, managerID, toBeRevokedID);
			System.out.printf(ACCESS_REVOKED, docName);
		}
	}
	
	/**
	 * Recebe um utilizador e o tipo de documento depois escreve todos os documentos do utilizador do tipo recebido.
	 * Pre: - docType != null && managerID != null 
	 * @param in - o input de onde os dados vao ser lidos.
	 * @param dManager - o SafeDocManager a listar os documentos officiais ou os documentos classificados.
	 */
	private static void processListUserDocs(Scanner in, SafeDocManager dManager) {
		String managerID = in.next();
		String docType = in.nextLine().trim().toLowerCase();

		if(!dManager.hasUser(managerID)) {
			System.out.println(NOT_REGISTERED);		
		}
		else if(dManager.isClerk(managerID) && docType.equals("classified")) {
			System.out.println(NO_CLEARANCE);
		}
		else {
			Iterator<Document> it = dManager.listUserDocs(managerID, docType);
			it.init();
			if(!it.hasNext()) {
				System.out.printf(NO_TYPE_DOCS, docType);
			}
			else {
				if(docType.equals("official")) {
					while(it.hasNext()) {
						OfficialDoc doc = (OfficialDoc) it.next();
						System.out.printf("%s %d: ", doc.getName(), doc.getNumberOfAccesses());
						if(doc.getNumberOfAccesses() == 0) {
							System.out.println(NO_ACCESSES);
						}
						else {
							Iterator<User> userIt = doc.getUserAccessesIterator();
							userIt.init();
							while(true) {
								User usr = userIt.next();
								if(userIt.hasNext()) {
									System.out.printf("%s [%s], ", usr.getID(), usr.getSecurityLevel());
								}
								else {
									System.out.printf("%s [%s]\n", usr.getID(), usr.getSecurityLevel());
									break;
								}
							}
						}
					}
				}
				else {
					while(it.hasNext()) {
						ClassifiedDoc doc = (ClassifiedDoc) it.next();
						System.out.printf("%s %s %d\n", doc.getName(),doc.getAccessLevel(), doc.getNumberOfAccesses());
						if(doc.getNumberOfAccesses() == 0) {
							System.out.println(NO_ACCESSES);
						}
						else {
							Iterator<User> userIt = doc.getUserAccessesIterator();
							Iterator<String> infoIt = doc.getInfoAccessesIterator();
							userIt.init();
							infoIt.init();
							while(true) {
								User usr = userIt.next();
								if(userIt.hasNext()) {
									System.out.printf("%s [%s, %s], ", usr.getID(), usr.getSecurityLevel(), infoIt.next());
								}
								else {
									System.out.printf("%s [%s, %s]\n", usr.getID(), usr.getSecurityLevel(), infoIt.next());
									break;
								}
							}
						}
						if(doc.getNumberOfLeaks() == 0) {
							System.out.println(NO_GRANTS);
						}
						else {
							Iterator<User> usrIt  = doc.getUserGrantsIterator();
							usrIt.init();
							Iterator<String> grantIt = doc.getInfoGrantsIterator();
							grantIt.init();
							while(true){
								User usr = usrIt.next();
								String info = grantIt.next();
								if(usrIt.hasNext()) {
									System.out.printf("%s [%s, %s], ", usr.getID(), usr.getSecurityLevel(), info);
								}
								else{
									System.out.printf("%s [%s, %s]\n", usr.getID(), usr.getSecurityLevel(), info);
									break;
								}
							}
						}
					}
				}	
			}
		}
	}

	/**
	 * Lista os documentos que foram cedidos mais vezes a utilizadores com nivel de seguranca insuficiente.
	 * @param dManager - o SafeDocManager a listar os 10 documentos que tem mais grants.
	 */
	private static void processListTopLeaked(SafeDocManager dManager) {
		Iterator<Document> it = dManager.listTopLeaked();
		it.init();
		int c = 0;
		if (!it.hasNext()) {
			System.out.println(NO_LEAKED_DOCUMENTS);
		}
		else {
			while (it.hasNext() && c < 10) {
				ClassifiedDoc doc = (ClassifiedDoc)it.next();
				System.out.printf("%s %s %s %d %d %d\n", doc.getName(), doc.getManager(), doc.getAccessLevel(),
						doc.getNumberOfAccesses(), doc.getNumberOfLeaks(), doc.getNumberOfRevokeds());
				c++;
			}
		}
	}
	
	/**
	 * Lista os 10 utilizadores que cederam mais grants na aplicacao.
	 * @param dManager - o SafeDocManager a listar os 10 utilizadores que deram mais grants .
	 */
	private static void processListTopGranters(SafeDocManager dManager) {
		Iterator<User> it = dManager.listTopGranters();
		it.init();
		int c = 0;
		if(!it.hasNext()) {
			System.out.println(NO_GIVEN_GRANTS);
		}
		else {
			while(it.hasNext() && c < 10) {
				Officer usr = (Officer)it.next();
				System.out.printf("%s %s %d %d %d\n", usr.getID(), usr.getSecurityLevel(), usr.getNumberOfDocs(), usr.getNumberOfGrants(),
						usr.getNumberOfRevokes());
				c++;
			}
		}
	}

	/**
	 * Escreve todos os comandos existentes no programa.
	 * @param dManager - o SafeDocManager a devolver os nomes dos comandos.
	 */
	private static void processHelp(SafeDocManager dManager) {
		for(AppCommands cmd : AppCommands.values()) {
			System.out.println(cmd.getDescription());
		}
	}


	/**
	 * Cria os objetos necessarios para o programa.
	 * Invoca o intrepretador de comandos e o leitor de comandos.
	 * @param args -argumentos para execucao da aplicacao. Nao utilizado neste programa. 
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		SafeDocManager dManager = new SafeDocManagerClass();

		String cmd = getCommand(in);

		while(!cmd.equals(EXIT)) {
			executeCommand(cmd, in, dManager);
			cmd = getCommand(in);
		}
		System.out.println(EXITING);
		
		in.close();
	}
	
}
