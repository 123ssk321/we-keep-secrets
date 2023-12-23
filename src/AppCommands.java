/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */


/**
 * Enumerado que contem todos os comandos do sistema.
 */


public enum AppCommands {
	
	/**
	 * Comandos do sistema.
	 */
	REGISTER ("register - registers a new user"),
	LISTUSERS ("listusers - list all registered users"),       
	UPLOAD ("upload - upload a document"),            
	READ ("read - read a document"),              
	WRITE ("write - write a document"),             
	GRANT ("grant - grant access to a document"),    
	REVOKE ("revoke - revoke a grant to access a document"),   
	USERDOCS ("userdocs - list the official or classified documents of an user"),    
	TOPLEAKED ("topleaked - list the top 10 documents with more grants"),  
	TOPGRANTERS ("topgranters - list the top 10 officers that have given more grants"), 
	HELP ("help - shows the available commands"),              
	EXIT ("exit - terminates the execution of the program");             

	/**
	 * Descricao do comando.
	 */
	private String description;

	
	/**
	 * Construtor do enumerado.
	 * Inicializa a variavel description com o parametro recebido.
	 * Pre: - description != null
	 * @param description - descricao do comando.
	 */
	private AppCommands(String description) {
		this.description = description;
	}
	
	
	/**
	 * Metodo que devolve uma descricao do comando.
	 */
	public String getDescription() {
		return description;
	}
	
}
