/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package documents;


/**
 * Classe que representa uma variante de Document contendo os metodos e variaveis 
 * associados aos documentos do tipo official.
 */


import accesshistory.AccessesRecord;
import accesshistory.LimitedHistoryClass;
import dataStructures.Iterator;
import users.User;


public class OfficialDocClass extends DocumentClass implements OfficialDoc {
	
	/**
	 * Tipo do documento.
	 */
	private static final String DOC_TYPE = "official";
	
	/**
	 * Historico de acessos de leitura ao documento.
	 */
	private AccessesRecord accessesTypeHistory;

	
	/**
	 * Construtor da classe que envoca o construtor da superclasse e
	 * inicializa as variaveis de instancia pertencentes a esta classe com os parametros recebidos. 
	 * Pre: - name != null && manager != null && accessLevel != null && description != null
	 * @param name - nome do documento.
	 * @param manager - identificador do dono do documento.
	 * @param accessLevel - nivel de seguranca do documento.
	 * @param description - descricao do documento.
	 */
	public OfficialDocClass(String name, String manager, String accessLevel, String description) {
		super(name, manager, accessLevel, description);
		accessesTypeHistory = new LimitedHistoryClass();
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
