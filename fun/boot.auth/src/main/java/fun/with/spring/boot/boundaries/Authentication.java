package fun.with.spring.boot.boundaries;


// TODO: Auto-generated Javadoc
/**
 * The Interface Authentication.
 */
public interface Authentication {

	/**
	 * Login.
	 *
	 * @param userIdentification
	 *            the user identification
	 * @param hashedPassword
	 *            the hashed password
	 * @return a root token
	 */
	public Token login(String userIdentification, String hashedPassword);
	
	/**
	 * Valid access.
	 *
	 * @param applicationToken
	 *            the application token
	 * @param applicationId
	 *            the application id
	 * @return the token
	 */
	public Token validAccess(Token applicationToken, String applicationId);
	
}
