package fun.with.spring.boot.impl;

import fun.with.spring.boot.boundaries.Token;

// TODO: Auto-generated Javadoc
/**
 * The Class TokenImpl.
 */
public class TokenImpl implements Token {

	/**
	 * Instantiates a new token impl.
	 */
	TokenImpl() {
	}

	/**
	 * Instantiates a new token impl.
	 *
	 * @param token
	 *            the token
	 * @param type
	 *            the type
	 */
	TokenImpl(String token, Type type) {
		this.value = token;
		this.type = type;

	}

	/** The value. */
	private String value;

	/** The type. */
	private Type type;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fun.with.spring.boot.boundaries.Token#getValue()
	 */
	@Override
	public String getValue() {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fun.with.spring.boot.boundaries.Token#getType()
	 */
	@Override
	public Type getType() {
		return type;
	}

}
