package fun.with.spring.boot.auth;

public interface Authentication {

	/**
	 * 
	 * @param userIdentification
	 * @param hashedPassword
	 * @return a root token
	 */
	public Token login(String userIdentification, String hashedPassword);
	
	/**
	 * 
	 * @param applicationToken
	 * @param applicationId
	 * @return
	 */
	public Token validAccess(Token applicationToken, String applicationId);
	
}
