package fun.with.spring.boot.impl;

import org.springframework.data.annotation.Id;

import fun.with.spring.boot.boundaries.Credentials;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
public class User {

	/** The user identification. */
	@Id
	private String userIdentification;

	/** The hashed password. */
	private String hashedPassword;

	/**
	 * Instantiates a new user.
	 */
	public User() {
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param credentials
	 *            the credentials
	 */
	public User(Credentials credentials) {
    	this(credentials.getUserIdentification(), credentials.getHashedPassword());
    }

	/**
	 * Instantiates a new user.
	 *
	 * @param userIdentification
	 *            the user identification
	 * @param hashedPassword
	 *            the hashed password
	 */
	public User(String userIdentification, String hashedPassword) {
		this.userIdentification = userIdentification;
		this.hashedPassword = hashedPassword;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userIdentification=" + userIdentification
				+ ", hashedPassword=" + hashedPassword + "]";
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
	 * Gets the hashed password.
	 *
	 * @return the hashed password
	 */
	public String getHashedPassword() {
		return hashedPassword;
	}
	
	
	

}
