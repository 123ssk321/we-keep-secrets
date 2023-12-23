/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package documents;


/*
 * 
 */


import dataStructures.Iterator;

/**
 * Interface da classe de topo que representa o documento.
 */


import users.User;


public interface Document {
	
	/**
	 * Redefine o metodo original da superclasse Object
	 * Verifica se obj e igual a uma variavel de instancia (neste caso, docName) de Document.
	 * Nesta aplicacao obj sera sempre do tipo String por isso nao contem as verificacoes standard
	 * do metodo original.
	 * Pre: - obj != null
	 * @param obj - objeto a ser comparado.
	 * @return true se a variavel for igual a obj.
	 */
	@Override
	boolean equals(Object obj);

	/**
	 * Devolve um iterador que itera sobre o historico
	 * de tipos de acessos no documento relacionados 
	 * com os utilizadores.
	 * @return - Devolve um objeto do tipo Iterator com o historico de acessos.
	 */
	Iterator<String> getInfoAccessesIterator();
	
	/**
	 * Devolve um iterador que itera sobre o historico
	 * de utilizadores que acederam ao documento.
	 * @return - Devolve um objeto do tipo Iterator com o historico de utilizadores.
	 */
	Iterator<User> getUserAccessesIterator();
		
	/**
	 * Devolve o numero de acessos ao documento.
	 * @return - numero de acessos ao documento.
	 */
	int getNumberOfAccesses();
	
	/**
	 * Devolve o numero de acessos para ler a descricao do documento.
	 * @return - numero de acessos para ler a descricao do documento.
	 */
	int getNumberOfReadAccesses();
	
	/**
	 * Devolve o nivel de seguranca do documento.
	 * @return - niveld de seguranca do documento.
	 */
	String getAccessLevel();
	
	/**
	 * Devolve a descricao do documento e adiciona o utilizador
	 * que acedeu ao documento para ler a descricao no historico
	 * de tipos de acessos ao documento do documento.
	 * Pre: - reader != null
	 * @param reader - objeto do tipo User que acedeu ao documento.
	 * @return - descricao do documento.
	 */
	String getDescription(User reader);
	
	/**
	 * Devolve o tipo do documento.
	 * @return - tipo do documento.
	 */
	String getDocType();
	
	/**
	 * Devolve o identificador do dono do documento.
	 * @return - identificadro do dono do documento.
	 */
	String getManager();
	
	/**
	 * Devolve o nome do documento.
	 * @return - nome do documento.
	 */
	String getName();
	
}
