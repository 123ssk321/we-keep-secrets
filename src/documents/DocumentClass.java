/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package documents;


/*
 * 
 */


import dataStructures.Iterator;

/**
 * Classe de topo que contem todos os metodos e variaveis associados aos
 * documentos comuns a todas as subclasses de documentos que possam existir
 * ou seja aos diferentes tipos de documentos.
 */


import users.User;


public abstract class DocumentClass implements Document {

	/**
	 * Numero de acessos ao Documento.
	 */
	protected int numberOfAccesses;
	
	/**
	 * Numero de vezes que o documento foi lido.
	 */
	protected int numberOfReadAccesses;
	
	/**
	 * Nome do documento.
	 */
	protected String docName;
	
	/**
	 * Identificador do utilizador que criou o documento.
	 */
	protected String managerID;
	
	/**
	 * Nivel de acesso do documento.
	 */
	protected String accessLevel;
	
	/**
	 * Descricao do documento.
	 */
	protected String description;

	
	/**
	 * Construtor da classe.
	 * Inicializa as variaveis de instancia com os parametros recebidos.
	 * Pre: - name!=null && manager!=null && acessLevel!=null && description!=null
	 * @param name - Nome do Documento.
	 * @param manager - Identificador do utilizador que criou o documento.
	 * @param accessLevel - Nivel de acesso do documento. 
	 * @param description - Descricao do documento.
	 */
	protected DocumentClass(String name, String manager, String accessLevel, String description) {
		numberOfAccesses = 0;
		numberOfReadAccesses = 0;
		docName = name;
		managerID = manager;
		this.accessLevel = accessLevel;
		this.description = description;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		return docName.equals(obj);
	}

	public abstract Iterator<String> getInfoAccessesIterator();
		
	public abstract Iterator<User> getUserAccessesIterator();
	
	@Override
	public int getNumberOfAccesses() {
		return numberOfAccesses;
	}

	@Override
	public int getNumberOfReadAccesses() {
		return numberOfReadAccesses;
	}

	@Override
	public String getAccessLevel() {
		return accessLevel;
	}
		
	public abstract String getDescription(User reader);
	
	public abstract String getDocType();
	
	@Override
	public String getManager() {
		return managerID;
	}

	@Override
	public String getName() {
		return docName;
	}	

}
