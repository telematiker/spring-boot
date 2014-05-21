package fun.with.spring.boot.boundaries;

// TODO: Auto-generated Javadoc
/**
 * The Interface Token.
 */
public interface Token {

	/**
	 * The Enum Type.
	 */
	public enum Type {

		/** The session. */
		SESSION,
		/** The call. */
		CALL;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue();

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public Type getType();

}
