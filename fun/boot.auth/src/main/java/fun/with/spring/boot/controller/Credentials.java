package fun.with.spring.boot.controller;

// TODO: Auto-generated Javadoc
/**
 * The Class Credentials.
 */
public class Credentials {
	
	/** The user identification. */
	public String userIdentification;
	
	/** The hashed password. */
	public String hashedPassword;

	/**
	 * Instantiates a new credentials.
	 */
	public Credentials() {
		super();
	}

	/**
	 * Gets the user identification.
	 *
	 * @return the user identification
	 */
	public String getUserIdentification() {
		return userIdentification;
	}

	/**
	 * Sets the user identification.
	 *
	 * @param userIdentification
	 *            the new user identification
	 */
	public void setUserIdentification(String userIdentification) {
		this.userIdentification = userIdentification;
	}

	/**
	 * Gets the hashed password.
	 *
	 * @return the hashed password
	 */
	public String getHashedPassword() {
		return hashedPassword;
	}

	/**
	 * Sets the hashed password.
	 *
	 * @param hashedPassword
	 *            the new hashed password
	 */
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
	

}
