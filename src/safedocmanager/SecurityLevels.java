/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */
package safedocmanager;


/**
 * Enumerado que contem os niveis de seguranca e compara-os.
 */


public enum SecurityLevels {
	
	/**
	 * Niveis de seguranca do sistema.
	 */
	TOPSECRET(3, "topsecret"),
	SECRET(2, "secret"),
	CONFIDENTIAL(1, "confidential"),
	OFFICIAL(0, "official");
	
	/**
	 * Numero que representa o nivel de seguranca.
	 */
	private int value;
	
	/**
	 * Nivel de seguranca.
	 */
	private String description;

	
	/**
	 * Construtor do enumerado.
	 * Inicializa as variaveis de instancia com os parametros recebidos.
	 * Pre: - value != null && description != null
	 * @param value - Numero que representa o nivel de seguranca.
	 * @param description - Nivel de seguranca.
	 */
	private SecurityLevels(int value, String description) {
		this.value = value;
		this.description = description;
	}

	
	/**
	 * Devolve um nivel de seguranca.
	 * @return - nivel de seguranca.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Devolve o numero que representa o nivel de seguranca.
	 * @return numero que representa o nivel de seguranca.
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Metodo que compara dois niveis de seguranca.
	 * Pre: other != null
	 * @param  other - nivel de seguranca a ser comparado.
	 * @return - true se other tiver um nivel de seguranca menor.
	 */
	public boolean isSuperiorThan(SecurityLevels other) {
		return this.value >= other.getValue();
	}
	
	/**
	 * Devolve o nivel de seguranca se tiverem um nivel de seguranca igual.
	 * Pre: description != null
	 * @param description - Nivel de seguranca.
	 * @return - Nivel de seguranca.
	 */
	public static SecurityLevels getSecurityLevel(String description) {
		for (SecurityLevels s : SecurityLevels.values())
			if (s.getDescription().equalsIgnoreCase(description))
				return s;
		return null;
	}

}
	


